
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form name="compForm" class="text" id="computerForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_computer"/>
    <input type="submit" class="button" name="catalog_computers" value="Computers"/>
</form>

<form name="caseForm" class="text" id="caseForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_case"/>
    <input type="submit" class="button" name="catalog_cases" value="Cases"/>
</form>

<form name="cpuForm" class="text" id="cpuForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_cpu"/>
    <input type="submit" class="button" name="catalog_cpu" value="CPU"/>
</form>

<form name="cmotherForm" class="text" id="motherBoardForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_motherboards"/>
    <input type="submit" class="button" name="catalog_motherboards" value="Motherboards"/>
</form>

<form name="ramForm" class="text" id="ramForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_ram"/>
    <input type="submit" class="button" name="catalog_ram" value="RAM"/>
</form>

<form name="videoCardForm" class="text" id="videoCardForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="show_catalog_video_cards"/>
    <input type="submit" class="button" name="catalog_video_cards" value="Video cards"/>
</form>
<div style="color:#ff0000">  ${addToCartError}</div>

</body>
</html>