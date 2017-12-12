User:<br>
${user.username}--->${user.email}<br>
List:<br>
<#list list as item >
    <font color="red">${item}<br></font>
</#list>
param:<br>
${RequestParameters.a}&nbsp;a=${param!}
