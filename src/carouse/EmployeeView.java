package carouse;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.event.RowEditEvent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

@ManagedBean
// @ViewScoped
public class EmployeeView implements Serializable {

	private List<Employee> employees;
	@ManagedProperty("#{empservice}")
	private EmployeeService employeeService;

	private Employee SelectEmployee;

	private List<String> filters;
	private List<String> filtersAddress;

	private List<Employee> filterEmployee;
	private ExcelOptions excelOpt;

	private PDFOptions pdfOpt;

	@PostConstruct
	public void init() {

		employees = employeeService.getAllEmployee();
		filters = new ArrayList<>();
		filters.add("user0");
		filters.add("user1");
		filtersAddress = new ArrayList<>();
		filtersAddress.add("add0");
		filtersAddress.add("add1");
		filters = new ArrayList<>();
		filters.add("add0");
		filters.add("add1");
		customizationOptions();
		filterEmployee = new ArrayList<>();
		filterEmployee.add(new Employee(1, "a", "", "ddd", ""));
		filterEmployee.add(new Employee(2, "c", "", "employees", ""));
		filterEmployee.add(new Employee(3, "v", "", "excel", ""));
		filterEmployee.add(new Employee(4, "b", "", "pdf", ""));

	}

	public void customizationOptions() {
		excelOpt = new ExcelOptions();
		excelOpt.setFacetBgColor("#F88017");
		excelOpt.setFacetFontSize("10");
		excelOpt.setFacetFontColor("#0000ff");
		excelOpt.setFacetFontStyle("BOLD");
		excelOpt.setCellFontColor("#00ff00");
		excelOpt.setCellFontSize("8");

		pdfOpt = new PDFOptions();
		pdfOpt.setFacetBgColor("#F88017");
		pdfOpt.setFacetFontColor("#0000ff");
		pdfOpt.setFacetFontStyle("BOLD");
		pdfOpt.setCellFontSize("12");

	}

	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}
	}

	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
		Document pdf = (Document) document;
		pdf.open();
		pdf.setPageSize(PageSize.A4);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images"
				+ File.separator + "employees.png";

		pdf.add(Image.getInstance(logo));
	}

	public ExcelOptions getExcelOpt() {
		return excelOpt;
	}

	public void setExcelOpt(ExcelOptions excelOpt) {
		this.excelOpt = excelOpt;
	}

	public PDFOptions getPdfOpt() {
		return pdfOpt;
	}

	public void setPdfOpt(PDFOptions pdfOpt) {
		this.pdfOpt = pdfOpt;
	}

	public List<String> getFiltersAddress() {
		return filtersAddress;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Employee Edited", ((Employee) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Employee) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<String> emp() {
		return filtersAddress;
	}

	public void setFiltersAddress(List<String> filtersAddress) {
		this.filtersAddress = filtersAddress;
	}

	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}

	public List<Employee> getFilterEmployee() {
		return filterEmployee;
	}

	public void setFilterEmployee(List<Employee> filterEmployee) {
		this.filterEmployee = filterEmployee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getSelectEmployee() {
		return SelectEmployee;
	}

	public void setSelectEmployee(Employee selectEmployee) {
		SelectEmployee = selectEmployee;
	}

	public void display(Employee employee) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Object  Selected : ", employee.getUsername()));
	}

	public void deleteEmp() {
		employees.remove(SelectEmployee);
		SelectEmployee = null;
	}

}
