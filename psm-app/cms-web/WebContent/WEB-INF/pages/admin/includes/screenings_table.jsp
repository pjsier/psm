<%@ include file="/WEB-INF/pages/admin/includes/taglibs.jsp"%>
<table
  id="${screeningsTableId}"
  class="generalTable fixedWidthTable"
  >

  <%--
    <colgroup>
      <col width="100"/>
    </colgroup>
  --%>

  <thead>
    <tr>
      <th>
        Date
        <span class="sep"></span>
      </th>
      <th>
        NPI
        <span class="sep"></span>
      </th>
      <th>
        Provider
        <span class="sep"></span>
      </th>
      <th>
        Provider Type
        <span class="sep"></span>
      </th>
      <th>
        Screening Type
        <span class="sep"></span>
      </th>
      <th>
        Reason
        <span class="sep"></span>
      </th>
      <th>
        Result
        <span class="sep"></span>
      </th>
      <th>
        Action
      </th>
    </tr>
  </thead>

  <tbody>
    <c:forEach var="screening" items="${screenings}">
      <tr>
        <td>${screening.date}</td>
        <td>${screening.npi}</td>
        <td>${screening.providerName}</td>
        <td>${screening.providerType}</td>
        <td>${screening.screeningType}</td>
        <td>${screening.reason}</td>
        <td>${screening.result}</td>
        <td><a href="#">Auto Screen</a> | <a href="#">Manual Screen</a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
