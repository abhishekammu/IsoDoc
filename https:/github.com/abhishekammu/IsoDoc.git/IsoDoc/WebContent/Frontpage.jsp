<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Map,java.util.List"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
<script type="text/javascript" src="Calendar/jquery-3.2.1.min.js"></script>
<LINK REL="stylesheet" type="text/css" href="Calendar/style.css" />
<LINK REL="stylesheet" type="text/css" href="Calendar/calendar.css" />
<script type="text/javascript" src="Calendar/calendar.js"></script>
<script type="text/javascript" src="Calendar/mycalendar.js"></script>
<script type="text/javascript" src="Calendar/tip.js"></script>
<LINK REL="stylesheet" type="text/css" href="Calendar/tip.css" />
<%
List<Map> isoformdetails=(List<Map>)request.getAttribute("isodetails");
System.out.println(isoformdetails);
%>
</head>
<body>
	<table bgcolor='#000080' width='100%' height='4%' cellpadding='0'
		cellspacing='0'>
		<tr>
			<td align='center' style="padding-left: 5%"><font face='verdana'
				size='4' color='#FFFFFF'> <b> Master List Of Documents </b>
			</font></td>
		</tr>
	</table>
	<TABLE BGCOLOR='#FFFFFF' CELLPADDING='1' CELLSPACING='1' width='100%'
		HEIGHT='10' border='0'>
		<tr>
			<td><table BGCOLOR='C0C0C0' align="center" cellpadding="2"
					border='0'>
					<div class="container-fluid">
						<div class="header">
							<div class="row">
								<div class="col-sm-4">
								<br>
								<br>
									<img src="images/drdologo1.png" class="img-rounded" width="150"
										height="150" align="left">
								</div>
								<form name="myform" action="TimesheetController" method="post">
									<tr>


										<td align="right"><font size='4'>Directorate:</font></td>
										<td><textarea name="Directorate" id=" " size="50" rows="2"
												cols="30" maxlength="60" required="required"></textarea></font></td>
									</tr>
									<tr>
										<td align="right"><font size='4' color='black'>Division:</font></td>
										<td><select Id="DEPT_NAME" name="Division" required="required"
											>
												<option value="">---Select---</option>
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="C">C</option>
												<option value="D">D</option>
												<option value="E">E</option>
										</select></td>



									</tr>

									<tr>
										<td align="right"><font size='4'>Type of Document:</font></td>
										<td><input type="radio" name="TypofDoc" id="maleBtn"  value="WP" required="required">
											<font size='4' color='black'>WP</font> 
											<input type="radio" name="TypofDoc" id="femaleBtn" value="WI">
											<font size='4' color='black'>WI</font>
											<input type="radio" name="TypofDoc" id="female1Btn" value="WPS">
											<font size='4' color='black'>WPS</font>
										</td>

									</tr>
									<tr>
										<td align="right"><font size="4">Document
												Nomenclature:</font></td>
										<td><textarea name="DocumentNomenclature" id=" " size="50" rows="2"
												cols="30" maxlength="60" required="required"></textarea></font></td>
										<td>
											<div id="fileUploadDiv">
												<input type="hidden" id="urlToUploadcertificateFile"
													value="uploadcertificatefile.jsp" /> <input type="hidden"
													id="maxSizePerFile" value="2048" /> <input type="file"
													name="CERTIFICATE" multiple="false" id="CERTIFICATE" /><input
													type="button" style='display: none'
													name="uploadcertificateButton" id="uploadcertificateButton"
													value="UPLOAD">
												<div id="fileUploadingStatusDiv"></div>
												<div id="uploadingDoneDiv" style="display: none;"></div>
											</div>
											<div id="resp"></div>
										</td>
									</tr>
									<tr>

										<td align="right"><font size='4'>Document No:</font></td>
										<td><textarea name="DocumentNo" id=" " size="50" rows="2"
												cols="30" maxlength="10" required="required"></textarea></font></td>
									</tr>
									<tr>
										<td align="right"><font size='4'>Revision Number:</font></td>
										<td><textarea name="RevisionNumber" id=" " size="50" rows="2"
												cols="30" maxlength="10" required="required"></textarea></font></td>
										<td align="right"><font size='4' color='black'>Revision
												Date:</font></td>
										<td><input type="text" name="RevisionDate" id="RevisionDate" size="12" VALUE=""></font>
											<img src="Calendar/calendar_sch.gif" name="showcal5"
											align="top" style="cursor: pointer"
											onclick="selectDateWithDrdlCal('RevisionDate');" /></td>
											
											
											
						
											
											
									</tr>
									<tr>
										<td align="right"><font size='4'>Issue Number:</font></td>
										<td><textarea name="IssueNumber" id=" " size="50" rows="2"
												cols="30" maxlength="10" required="required"></textarea></font></td>
										<td align="right"><font size='4' color='black'>Issue
												Date:</font></td>
										<td><input type="text" name="IssueDate" id="IssueDate" size="12" VALUE=""></font>
											<img src="Calendar/calendar_sch.gif" name="showcal5"
											align="top" style="cursor: pointer"
											onclick="selectDateWithDrdlCal('IssueDate');" /></td>
									</tr>
									<tr>

										<td align="right"><font size='4'>Remarks:</font></td>
										<td><textarea name="Remarks" id=" " size="50" rows="2"
												cols="30" maxlength="60" required="required">
						</textarea></td>


										<div class="col-sm-4">
											<img src="images/emblem.jpg" class="img-rounded" width="180"
												height="170" align="right">
										</div>
							</div>
						</div>
					</div>
					</tr>
					<tr>
						<td align="right"><input type="hidden" name="update"
							id="update"> <input type="hidden" name="F_Directorate "
							id="F_Directorate">
							<button type="submit" name="save" id="save" class="submit"
								onclick="TimesheetController">Save</button>
							<button type="reset" class="reset" name="reset"
								onclick="window.location='Frontpage.jsp';">
								<font size="2">Reset</font>
							</button>
							<button type="button" name="delete" id="delete" value="Delete"
								class="submit" onclick=Delete()>Delete</button></td>
					</tr>
				</TABLE>
				</form>



				<table bgcolor='#000066' width='100%' height='5%' border='0'
					cellpadding='0' cellspacing='0'>
					<tr>
						<td align='center'>
					</tr>
				</table> <br> <br>
				<table  align="center" border="1" cellpadding="3" cellspacing="0">
					<tr align="center">
						<td><b><font size="3" color="#000066">Directorate</font><font
								size="2" color="red"></font></b></td>
						<td><b><font size="3" color="#000066">Division</font></b></td>
						<td><b><font size="3" color="#000066">Type of
									Document</font></b></td>
						<td><b><font size="3" color="#000066">Document
									Nomenclature</font></b></td>
						<td><b><font size="3" color="#000066">Document No</font></b></td>
						<td><b><font size="3" color="#000066">Revision no</font></b></td>
						<td><b><font size="3" color="#000066">Revision
									Date</font></b></td>
						<td><b><font size="3" color="#000066">Issue No</font></b></td>
						<td><b><font size="3" color="#000066">Issue Date</font></b></td>
						<td><b><font size="3" color="#000066">Remarks</font></b></td>
						<tbody>
					<% if(isoformdetails!= null)for(int i=0;i< isoformdetails.size();i++){ 
						Map map = isoformdetails.get(i);
					%>
						<tr>
					
							<td><%= map.get("F_Directorate") %> </td>
							<td><%= map.get("F_Division") %></td>
							<td><%= map.get("F_TypofDoc") %></td>
							<td><%= map.get("F_DocNomen") %></td>
							<td><%= map.get("F_DocNo") %></td>
							<td><%= map.get("F_RevNo") %></td>
							<td><%= map.get("F_RevDt") %></td>
							<td><%= map.get("F_IssueNo") %></td>
							<td><%= map.get("F_IssueDt") %></td>
							<td><%= map.get("F_Remarks") %></td>
						</tr>
						
					<%} %>
					</tbody>
						</table>
</body>
</html>