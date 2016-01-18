package com.wisesz.health.wsdl;

import com.wisesz.health.wsdl.bean.AuthInfo;
import com.wisesz.health.wsdl.bean.HospInfoFilter;
import com.wisesz.health.wsdl.bean.Hospital;
import com.wisesz.health.wsdl.bean.Hospital.NotifyType;
import com.wisesz.health.wsdl.bean.PatientIdentify;
import com.wisesz.health.wsdl.bean.PatientInfo;
import com.wisesz.health.wsdl.bean.RegFrom;
import com.wisesz.health.wsdl.bean.RegInfo;
import com.wisesz.health.wsdl.bean.RegInfo.OperType;
import com.wisesz.health.wsdl.bean.RegInfoFilter;
import com.wisesz.health.wsdl.handler.WsdlHandler.WSDLParam;

/**
 * szregplat对接服务
 * 
 * @author Administrator
 *
 */
public class RegplatService {
	private static RegplatService service;

	public static RegplatService getService() {
		if (service == null) {
			synchronized (RegplatService.class) {
				if (service == null) {
					service = new RegplatService();
				}
			}
		}
		return service;

	}

	/**
	 * 获取医院信息:该过程被“预约服务前端提供方”调用，并用于: -从公共预约平台获取可提供预约的医院列表.
	 * -从公共预约平台获取单个医院的科室基本信息列表 -从公共预约平台获取单个医院的专家基本信息列表
	 * -从公共预约平台获取单个医院的科室和专家排班信息列表
	 * 
	 * @param authInfo
	 *            向预约平台发起请求所需携带的鉴权信息，包括用户名和密码，密码采用MD5摘要算法
	 * @param filter
	 *            通知单个医院信息的变更，变更仅限医院基本信息变更、科室基本信息变更、专家基本信息变更、排班信息变更之一.
	 * @param notifyAddr
	 * @return 请求方发现返回结果为成功，则比较返回的HospName列表，如果与之前获得的列表不一致，应当以返回的列表替换更新本地的列表.
	 *         Depart和Doctor元素也按此处理。然后继续以下处理：
	 *         请求方根据DepartType指示的科室类型，如果为普通科室类型，或者为普通和专家科室类型，
	 *         则在用户界面的普通科室预约中呈现相应的排班；如果为专家科室类型，或者为普通和专家科室类型，
	 *         则在用户界面的专家预约中呈现所包含的专家相应的排班。
	 *         当请求方获取排班信息，且请求过滤参数中的DepartName和DoctorName同时存在时，表明获取指定的专家排班；
	 *         如DepartName存在，DoctorName不存在，表明获取指定的普通科室排班，即使该科室是普通和专家类型。
	 *         以上两种情况在预约业务发起前应当调用，用于校验用户行为是否符合最新的排班信息。如DepartName和DoctorName都不存在
	 *         ，表明获取该医院所有的普通科室排班和专家科室排班。
	 *         请求方应当在获取医院信息后，为每位医生建立唯一识别索引，DepartName和DoctorName共同决定一位医生，
	 *         如果同一家医院同一科室有重名的医生，还需要比较DocMajor字段用以区分。
	 *         接收方未能查找到请求过滤参数中指定的信息，应当返回60X的错误码.如果未发现处理错误，应当返回符合参考文档中XML-
	 *         schema约束的信息内容。 如果NotifyAddr存在，接收方应保存至缓存中，用于信息变更时通知。
	 */
	public String getHospInfo(AuthInfo authInfo, HospInfoFilter filter, String notifyAddr) {
		WSDLParam param = new WSDLParam("GetHospInfoReq");
		param.addParam(authInfo.toDocument());
		param.addParam(filter.toDocument());
		param.addParam("NotifyAddr", notifyAddr);
		return param.execute();
	}

	/**
	 * 通知医院信息变更:本接口由预约前端服务提供商提供wsdl定义，由预约公共平台调用: -用于通知医院信息的变化，主要是排班信息的变更通知.
	 * 
	 * @param hospital
	 *            Hospital信息元素的内容根据通知的类型而变化，但应符合上一个接口的规定。信息元素包含某种通知类型的全部数据，
	 *            包含变化的和未变化的数据。
	 *            预约平台发现信息变更时，应首先从缓存中获取对端地址列表，逐一发起通知请求。如果缓存未建立，则访问“VendorInfo”
	 *            数据表中所有第三方厂商， 获得配置的通知地址列表，逐一发起通知请求。
	 * @param notifyType
	 * @return
	 */
	public String notifyHospInfo(Hospital hospital, NotifyType notifyType) {
		WSDLParam param = new WSDLParam("NotifyHospInfoReq");
		param.addParam(hospital.toDocument());
		param.addParam("NotifyType", notifyType.toString());
		return param.execute();
	}

	/**
	 * 查询预约信息:本接口由预约前端服务提供商调用，查询公共预约平台保存的患者信息和/或预约信息，或者医院端保存的用户预约情况:
	 * -查询预约平台保存的患者信息 -查询预约平台保存的历史预约信息. -通过预约平台查询，用户在医院端保存的其他途径预约的信息
	 * 
	 * @param authInfo
	 *            向预约平台发起请求所需携带的鉴权信息，包括用户名和密码，密码采用MD5摘要算法
	 * @param patientIdentify
	 *            身份证字段必选。SN字段可选，当预约前端服务提供商保存了用户上次预约成功后预约平台返回的SN时，可以携带SN查询
	 *            该预约记录的变化情况。Other字段可选，用于提供给预约平台核对姓名和联系电话。
	 * @param regInfoFilter
	 *            查询预约记录时所需携带的请求过滤信息.
	 *            查询预约记录时必须存在.BeginDate和EndDate字段必须存在。如果DepartName
	 *            存在，则HospName必须存在；如果DoctorName存在，则DepartName必须存在
	 * @return 本接口用于查询指定的用户（以身份证号码字段唯一标识）在一段时期内的预约情况，所查询的预约情况不仅限于通过预约平台的预约，
	 *         还包含医院端记录的其他途径的预约，例如院内诊间预约. 接收到预约请求后, 预约平台应当以以下顺序进行处理
	 *         (如果有错误发生，应返回相应的错误码): 
	 *         		1. 检查携带的鉴权信息是否合法，如果不合法，返回“306用户未授权”.用户合法，继续处理. 
	 *         		2. 根据身份证号码检查用户在预约平台是否存在. 如果不存在，响应中的结果码设置为“601没有此用户”，处理结束. 
	 *         		3.如果Other字段存在，则比较其中的数据是否与预约平台保存的数据匹配，如果不匹配，响应中的结果码设置为“203数据与保存的
	 *         		    不匹配”，处理结束. 
	 *         		4. 填写响应中的用户信息. 如果Filter不存在，表明仅查询用户，向对端返回成功，处理结束.
	 *         		5. 如果SN字段存在，则根据SN查询预约记录（忽略Filter信息元素），如果查询不到则返回“602没有预约记录”，查询到预约信息
	 *         		    返回相应的预约记录，处理结束.如果SN字段不存在，继续处理. 
	 *         		6.判定Filter携带的参数是否合法，其中EndDate应不早于BeginDate，且EndDate-BeginDate应不超过1年，但不应检查BeginDate
	 *         		   与当前日期的关系。 
	 *         		7.如果Filter携带的参数中HospName存在，则向医院发起查询预约请求。 
	 *         		8.根据Filter携带的参数查询系统保存的记录，合并第7步查询医院的结果（与医院查询结果有重复的，仅保留医院端返回的记录）。
	 *        		   合并后的记录如果为空，则返回“602 没有预约记录”，否则返回相应的1条或多条预约记录.如果预约平台不能处理上述步骤，例如，
	 *        		   发生了数据库异常，应当停止处理并设置相应的错误返回码.
	 */
	public String getRegInfo(AuthInfo authInfo, PatientIdentify patientIdentify, RegInfoFilter regInfoFilter) {
		WSDLParam param = new WSDLParam("NotifyHospInfoReq");
		param.addParam(authInfo.toDocument());
		param.addParam(patientIdentify.toDocument());
		param.addParam(regInfoFilter.toDocument());
		return param.execute();
	}

	/**
	 * 查询号源信息:本接口由预约前端服务提供商调用，查询公共预约平台某个特定排班的号源情况: -查询预约平台从医院获取的号源情况.
	 * 
	 * @param authInfo
	 *            向预约平台发起请求所需携带的鉴权信息，包括用户名和密码，密码采用MD5摘要算法
	 * @param regInfoFilter
	 *            向预约平台发起请求所需携带的请求过滤信息. DoctorName在查询专家排班时必须存在.
	 * @return
	 * 			本接口用于查询医院的号源情况.对于号源托管在预约平台，或者非实时接口的医院，预约平台返回本地保存的当前号源情况；对于实时交互接口的医院，预约平台实时查询医院的号源。
	 *			接收到预约请求后, 预约平台应当以以下顺序进行处理 (如果有错误发生，应返回相应的错误码):
	 *			1.	检查携带的鉴权信息是否合法，如果不合法，返回“306 用户未授权”.用户合法，继续处理.
	 *			2.	检查Filter携带的参数是否完整。.
	 *			3.	根据预约平台的策略，预约平台可以根据配置决定是否返回缓存的号源情况，如果决定返回缓存的号源信息，且存在满足的Filter条件的记录，则返回该号源信息，处理结束. 如果决定不返回缓存中的信息，则继续处理.
	 *			4.	根据Filter携带的HospName参数，预约平台判断号源获取是否需要实时与医院交互，如果需要则向医院发起请求，将医院返回的结果组装到响应中. 如果不需要交互，则返回本地当前的号源情况.
	 *			如果排班已停诊或停挂，返回7XX业务错误码，处理结束。返回的PoolInfo号源信息中，PoolInfo列表中的最后一个成员的EndTime元素必定存在.如果前一个成员的EndTime与后一个元素的StartTime相同，则前一个成员的EndTime可以省略。每个成员的TotalNum如果等于1，则TotalNum字段可以不出现。
	 *			如果预约平台不能处理上述步骤，例如，发生了数据库异常，应当停止处理并设置相应的错误返回码.
	 */
	public String getRegPool(AuthInfo authInfo, RegInfoFilter regInfoFilter) {
		WSDLParam param = new WSDLParam("GetRegPoolReq");
		param.addParam(authInfo.toDocument());
		param.addParam(regInfoFilter.toDocument());
		return param.execute();
	}

	/**
	 * * 预约/退号/修改预约
	 * 
	 * @param AuthInfo
	 *            	向预约平台发起请求所需携带的鉴权信息，包括用户名和密码，密码采用MD5摘要算法
	 * @param operType
	 *            	操作类型（AddReg、DelReg、ModReg）指示新增、修改、删除操作之一。
	 * @param sn
	 *            	挂号流水号(如果之前预约前端服务提供商保存了预约平台返回的用户挂号流水号，本
	 *            	次操作是修改或删除操作，则可以携带SN字段，预约平台发现携带SN字段将忽略RegInfo字段)
	 * @param patientInfo
	 *            	病人信息(新增/修改/删除都必须携带。其中Phone字段在新增操作时必须携带。修改操作时
	 *            	IdCard字段必须与原先新增操作时携带的相同，也即不支持修改身份证号码的操作。Sex和
	 *           	 Birth字段可选，预约平台会根据IdCard字段解析生成。)
	 * @param regInfo
	 *            	挂号信息(OperType为新增时必须存在。OperType为修改时，不需携带，预约平台忽略该元素，仍会同时修改患者基本信息和所有有效预约记录中的患者信息。
	 *				OperType为删除时，如果SN字段不存在，则本信息元素必须存在.支持付费的预约前端服务提供商必须携带IsPayed字段。除预约挂号以外的其他种类预约，
	 *				必须携带RegOperType字段。预约专家排班时DoctorName字段必须存在。StartTime和EndTime必须匹配GetRegPool接口返回的PoolInfo信息元素列表之一。)
	 * @param regFrom
	 *            	挂号来源(必须携带，表明预约的途径（网站、手机、电话、电视、自助机、服务台）和预约的来源提供商标识，以及操作员信息. 患者发起的申请，操作人
	 *            	填写患者姓名，客服代理患者发起的申请，操作人填写客服工号，系统自动发起的申请，操作人填写“系统”.)
	 * @return
	 * 				本接口用于预约前端服务提供商通过预约平台向医院发起预约，或修改用户的姓名/电话/医保类型/付费状态，或对某一条预约作撤销（对预约挂号的预约类型，称为退号）.修改请求会同时变更预约平台保存的用户信息和所有已经传送到医院的，未过期未完成的预约记录中的用户信息（不包括医院端自行预约的记录），或者修改单条预约记录的支付状态.修改请求不支持变更预约记录中的医院、科室、医生、就诊日期等信息，如果需要修改只能退号后重新预约。
	 *				接收到预约请求后, 预约平台应当以以下顺序进行处理 (如果有错误发生，应返回相应的错误码):
	 *				1.	检查携带的鉴权信息是否合法，如果不合法，返回“306 用户未授权”.用户合法，继续处理.
	 *				2.	检查请求参数是否合法，如果不符合表6.3.1.1和6.3.1.2规定的参数要求，返回相应的错误码，处理结束. 
	 *				3.	检查请求参数中的OperType:
	 *				-	OperType指示为新增，根据RegInfo中的身份证号码检查用户在预约平台是否存在. 如果不存在则新增用户信息. 如果存在但其他信息不匹配，返回“203 数据与保存的不匹配”，处理结束. 继续检查RegInfo信息:
	 *					-	预约平台根据请求参数查询本地保存的预约记录，如果已经存在匹配的记录，则返回“305 记录已存在”，并携带本地查询到的预约记录（可能来源不同），处理结束.
	 *				-	预约平台根据本地缓存的排班信息，检查预约请求是否满足预约条件，如儿科年龄限制，产科性别限制，医保医院限制等。如果不满足条件，返回业务层失败码.
	 *					-	预约平台根据本地缓存策略决定在本地检查或者向医院发起排班查询请求，检查请求的排班是否存在，以及是否正常而非停诊状态。如已停诊应返回失败，查询超时应根据本地缓存信息继续处理.
	 *					-	预约平台根据本地缓存策略决定是否向医院发起该排班的号源查询请求，核实请求的时间段是否可用，以防止其他途径的并发预约请求造成号源被占用。查询失败应根据本地缓存信息继续处理.
	 *					-	预约平台根据号源管理方式的不同，决定是否向医院发起预约请求，并检查返回结果.
	 *				-	如果医院端返回超时，预约平台应向医院发起查询预约请求GetRegInfo，检查医院端是否已成功。如已经成功，则本地需保存预约记录，并向预约前端服务提供商返回成功；如返回超时或返回查询不到记录，则向预约前端服务提供商返回失败. 
	 *				-	如果医院端返回结果表明重复预约，预约平台应向医院发起查询预约请求GetRegInfo，检查医院端该预约是其他途径的并发预约造成，还是同一用户早先已经预约，向预约前端服务提供商返回不同的失败码.
	 *				-	如果医院端返回成功，预约平台本地保存预约记录，向预约前端服务提供商返回预约成功，参数中携带取号时间段字符串。设置号源缓存不可靠标记。
	 *				-	OperType指示为修改，根据RegInfo中的身份证号码检查用户在预约平台是否存在. 如果不存在则返回“601 没有此用户”. 
	 *				-	预约平台检查存在待修改的字段。如果不存在，返回“202 数据不完整”.
	 *				-	预约平台根据请求修改本地用户信息或支付状态. 如果数据库错误，向对端返回“307 数据库错误”.
	 *				-	预约平台查询就诊时间从当日起一个月内本地保存的该用户的所有预约记录. 对每条记录作如下处理：
	 *				-	预约平台根据号源管理方式的不同，决定是否向医院发起修改请求.	如果决定不向医院端发起修改请求，则检查时间规则是否允许修改，修改预约信息后继续下一条预约记录处理. 如果向医院发起修改请求，应检查返回结果.
	 *				-	对于医院返回失败的情况平台需给出告警. 同时应检查该条预约记录是否与预约前端服务提供商发起的请求所携带的参数相匹配（根据SN字段或RegInfo字段），如果一致需向预约前端服务提供商返回处理失败，处理结束. 如果不一致继续下一条预约记录处理.
	 *				-	OperType指示为删除，根据RegInfo中的身份证号码检查用户在预约平台是否存在. 如果不存在则返回“601 没有此用户”.
	 *					-	预约平台检查是否存在SN字段或RegInfo字段。如果都不存在，返回“202 数据不完整”.
	 *				-	预约平台查询本地保存的该用户的预约记录. 如果查询结果为空，返回“602 没有预约记录” 跳转到第4步继续处理. 如果查询结果多于1条记录，返回“607 存在多条满足要求的记录，无法继续处理”. 如果数据库错误，向对端返回“307 数据库错误”.
	 *				-	预约平台检查查询到的预约记录，检查是否满足退号条件:是否过期，是否已取号.如果不满足退号条件，向对端返回“7XX”的业务层处理错误.
	 *				-	预约平台对本地保存的对应预约记录增加撤销标记和撤销时间.
	 *				-	预约平台根据号源管理方式的不同，决定是否向医院发起退号请求，并检查返回结果.
	 *				-	预约平台向预约前端服务提供商返回处理结果.
	 *				4.	如果前述步骤处理成功. 预约平台保存请求参数携带的RegFrom信息元素.
	 *				如果预约平台不能处理上述步骤，例如，发生了数据库异常，应当停止处理并设置相应的错误返回码.
	 */
	public String register(AuthInfo authInfo, OperType operType, String sn, PatientInfo patientInfo, RegInfo regInfo,
			RegFrom regFrom) {
		WSDLParam param = new WSDLParam("RegisterReq");
		param.addParam(authInfo.toDocument());
		param.addParam("OperType", operType.toString());
		param.addParam("SN", sn);
		param.addParam(patientInfo.toDocument());
		param.addParam(regInfo.toDocument());
		param.addParam(regFrom.toDocument());
		return param.execute();
	}

	/**
	 * 第三方数据交换
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @param operType
	 *            操作类型（Update、Query）
	 * @param vendor
	 *            前端服务提供商标识
	 * @param key
	 *            自定义主键
	 * @param data
	 *            私有透明数据
	 * @return
	 */
	public String exPrivateData(AuthInfo authInfo, String operType, String vendor, String key, String data) {
		WSDLParam param = new WSDLParam("ExPrivateDataReq");
		param.addParam(authInfo.toDocument());
		param.addParam("OperType", operType);
		param.addParam("Vendor", vendor);
		param.addParam("Key", key);
		param.addParam("Data", data);
		return param.execute();
	}

	/**
	 * 第三方获取新闻
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @param newsStartTime
	 *            新闻开始时间
	 * @param newsEndTime
	 *            新闻结束时间
	 * @return
	 */
	public String getNews(AuthInfo authInfo, String newsStartTime, String newsEndTime) {
		WSDLParam param = new WSDLParam("GetNewsReq");
		param.addParam(authInfo.toDocument());
		param.addParam("NewsStartTime", newsStartTime);
		param.addParam("NewsEndTime", newsEndTime);
		return param.execute();
	}

}
