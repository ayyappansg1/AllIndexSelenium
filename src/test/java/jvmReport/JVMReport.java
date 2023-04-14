package jvmReport;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void jvmReportGeneration(String json) {
		File file=new File("C:\\Users\\ayyappan.g\\eclipse-workspace\\AllIndex\\target");
		Configuration confi=new Configuration(file, "AllIndex");
		confi.addClassifications("Project", "Allindex");
		confi.addClassifications("Module", "Compare");
		List<String> li=new LinkedList<>();
		li.add(json);
		ReportBuilder builder=new ReportBuilder(li, confi);
		builder.generateReports();
	}
			
			
			

}
