package me.zzd.webapp.core.plugin;

import java.io.File;
import java.util.List;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.IDataSourceProvider;
import com.jfinal.plugin.activerecord.Model;

import me.zzd.webapp.core.annotation.BindTable;
import me.zzd.webapp.core.handler.ClassSearch;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AutoTableBindPlugin extends ActiveRecordPlugin {
	private String scanPackage;
	private boolean autoScan = true;
	private Class target;

	public AutoTableBindPlugin(IDataSourceProvider dataSourceProvider) {
		this(dataSourceProvider, "");
	}

	public AutoTableBindPlugin(IDataSourceProvider dataSourceProvider, String scanPackage) {
		this(dataSourceProvider, scanPackage, Model.class);
	}

	public AutoTableBindPlugin(IDataSourceProvider dataSourceProvider, String scanPackage, Class target) {
		super(dataSourceProvider);
		this.scanPackage = scanPackage;
		if (Model.class.isAssignableFrom(target)) {
			this.target = target;
		} else {
			this.target = null;
			Log.getLog(getClass()).error("设置的target扫描类类型不是model类类型的子类！");
		}
	}

	@Override
	public boolean start() {
		if (target != null) {
			try {
				List<Class> scanResults = ClassSearch.ofTarget(target).ofScanPackege(scanPackage).search();
				for (Class cls : scanResults) {
					BindTable table = (BindTable) cls.getAnnotation(BindTable.class);
					if (table != null) {
						addMapping(table.tableName(), table.pkName(), cls);
					} else {
						if (isAutoScan()) {
							addMapping(cls.getSimpleName(), cls);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.start();
	}

	public boolean isAutoScan() {
		return autoScan;
	}

	public void setAutoScan(boolean autoScan) {
		this.autoScan = autoScan;
	}
}
