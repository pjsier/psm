<%--
 Copyright (C) 2012 TopCoder Inc., All Rights Reserved.

 @author TCSASSEMBLER
 @version 1.0

 The common footer for all the jsps of the application.
--%>
<%@ include file="/WEB-INF/pages/admin/includes/taglibs.jsp" %>

<jsp:useBean id="date" class="java.util.Date" />
                    <!-- /.tabSection -->
                </div>
            </div>
            <!-- /#mainContent -->

            <div id="footer">
                <!-- TODO: I don't think this is how copyright actually 
                     works.  The copyright date(s) should be the union
                     of the years in which components of the collective
                     work were actually written.  We can't just
                     programmatically substitute in today's date and 
                     assume it's accurate as a copyright date. -->
                <strong>Copyright <fmt:formatDate value="${date}" pattern="yyyy" />.</strong> TopCoder, Inc; Solution Guidance Corporation
            </div>
            <!-- #footer -->
            <div class="clear"></div>
        </div>
        <!-- /#wrapper -->
        <%@ include file="/WEB-INF/pages/admin/includes/modal.jsp" %>
        <input type="hidden" value="<c:url value='/admin/user/list' />" id="userAccountsURL" />
    </body>
</html>
<script type="text/javascript">
var ctx = "${ctx}";
var roles = "${role}";
var searchedResult = "${searchedResult}";
var searchFirstName = "${searchFirstName}";
</script>