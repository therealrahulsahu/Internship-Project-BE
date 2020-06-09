<%@ page import="com.database.MySQLTool" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.database.CustomerInvoicePOJO" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Invoices</title>
    <style>
        table, th, td {
            border: 2px solid black;
            border-collapse: collapse;
            margin:2px 5px 2px 2px;
        }
    </style>
</head>
<body>
<%
    MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");
    Integer number = 50;
    try{
        number = Integer.parseInt(request.getParameter("number_of_item"));
    }catch (Exception e){
    	 out.print(e.toString());
    }

    ArrayList<CustomerInvoicePOJO> searched = DB.getAllData(number);
    CustomerInvoicePOJO sample = new CustomerInvoicePOJO();
    String[] features = sample.features;
%>

<table><tr>
    <%
        for(String name: features){
    %>
    <th><%=name %></th>
    <%
        }
    %>
</tr>
    <%
        for(CustomerInvoicePOJO tuple: searched){
    %>
    <tr>
        <td><%= tuple.getPk_id() %></td>
        <td><%= tuple.getAcct_doc_header_id() %></td>
        <td><%= tuple.getCompany_id() %></td>
        <td><%= tuple.getDocument_number() %></td>
        <td><%= tuple.getDocument_number_norm() %></td>
        <td><%= tuple.getBusiness_code() %></td>
        <td><%= tuple.getCreate_year() %></td>
        <td><%= tuple.getDocument_line_number() %></td>
        <td><%= tuple.getDoctype() %></td>
        <td><%= tuple.getCustomer_number() %></td>
        <td><%= tuple.getCustomer_number_norm() %></td>
        <td><%= tuple.getFk_customer_map_id() %></td>
        <td><%= tuple.getCustomer_name() %></td>
        <td><%= tuple.getDivision() %></td>
        <td><%= tuple.getDocument_create_date() %></td>
        <td><%= tuple.getDocument_create_date_norm() %></td>
        <td><%= tuple.getPosting_date() %></td>
        <td><%= tuple.getPosting_date_norm() %></td>
        <td><%= tuple.getPosting_id() %></td>
        <td><%= tuple.getDue_date() %></td>
        <td><%= tuple.getDue_date_norm() %></td>
        <td><%= tuple.getOrder_date() %></td>
        <td><%= tuple.getOrder_date_norm() %></td>
        <td><%= tuple.getInvoice_id() %></td>
        <td><%= tuple.getInvoice_id_norm() %></td>
        <td><%= tuple.getBaseline_create_date() %></td>
        <td><%= tuple.getInvoice_date_norm() %></td>
        <td><%= tuple.getTotal_open_amount() %></td>
        <td><%= tuple.getTotal_open_amount_norm() %></td>
        <td><%= tuple.getCust_payment_terms() %></td>
        <td><%= tuple.getBusiness_area() %></td>
        <td><%= tuple.getShip_date() %></td>
        <td><%= tuple.getShip_to() %></td>
        <td><%= tuple.getClearing_date() %></td>
        <td><%= tuple.getClearing_date_norm() %></td>
        <td><%= tuple.getReason_code() %></td>
        <td><%= tuple.getIsopen() %></td>
        <td><%= tuple.getDiscount_due_date_norm() %></td>
        <td><%= tuple.getDebit_credit_indicator() %></td>
        <td><%= tuple.getPayment_method() %></td>
        <td><%= tuple.getDocument_creation_date() %></td>
        <td><%= tuple.getInvoice_amount_doc_currency() %></td>
        <td><%= tuple.getDocument_id() %></td>
        <td><%= tuple.getActual_open_amount() %></td>
        <td><%= tuple.getPaid_amount() %></td>
        <td><%= tuple.getDayspast_due() %></td>
        <td><%= tuple.getInvoice_age() %></td>
        <td><%= tuple.getDisputed_amount() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>