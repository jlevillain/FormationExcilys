<jsp:include page="include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <section id="main">
        	<h1>Add Computer</h1>
        <form class="form-horizontal">
            <div class="form-group">
                <div class="clearfix">
                    <label label-default for="name">Computer name:</label>
                    <input type="text" name="name" />	<span class="muted">Required</span>
                </div>
            </div>
        </form>
        <form class="form-group" action="AddComputer" method="POST">
            <fieldset>
                <div class="clearfix">
                    <label label-default for="name">Computer name:</label>
                    <div class="input-group">
                        <input type="text" name="name" />	<span class="help-block">Required</span>
                    </div>
                </div>
                <div class="clearfix">
                    <label label-default for="introduced">Introduced date:</label>
                    <div class="input">
                        <input class="form-control" type="date" name="introducedDate" />	<span class="help-block">YYYY-MM-DD</span>
                    </div>
                </div>
                <div class="clearfix">
                    <label label-default for="discontinued">Discontinued date:</label>
                    <div class="input">
                        <input type="date" name="discontinuedDate" />	<span class="help-block">YYYY-MM-DD</span>
                    </div>
                </div>
                <div class="clearfix">
                    <label label-default for="company">Company Name:</label>
                    <div class="input">
                        <select name="company">
                            <option value="null">--</option>
                            <c:forEach var="item" items="${companyList}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                            <!-- <option value="0">--</option>

						<option value="1">--</option>

						<option value="1">Apple</option>

						<option value="2">Dell</option>

						<option value="3">Lenovo</option>

						-->
                        </select>
                    </div>
                </div>
            </fieldset>
            <div class="actions">
                <input type="submit" value="Add" class="btn btn-primary">or <a href="DashBoard" class="btn btn-default">Cancel</a>
            </div>
        </form>
    </section>
    <jsp:include page="include/footer.jsp" />