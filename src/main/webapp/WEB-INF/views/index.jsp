<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${name}</title>

</head>
<body>

    <b><h1>${name}</h1></b>
    <b><p>Trainer:</p></b>
    <b><h2>${trainerName}</h2></b>
    <b><p>Pokemon:</p></b>
    <ol>
<c:forEach items="${pokemon}" var="pokemon">
    <li><c:out value="${pokemon.pokemonName}"/></br></li>
    <ul>
    <li><c:out value="${pokemon.pokemonDesc}"/></li>
    <li><c:out value="${pokemon.pokemonGeneration}"/></li>
    <li><c:out value="${pokemon.pokemonEvolution}"/></li>
    <c:forEach items="${pokemon.elementTypes}" var="element_type">
        <li><c:out value="${element_type.elementType}"/></li>
        <li><c:out value="${element_type.elementTypeDesc}"/></li>
    </c:forEach>
    </ul>
</c:forEach>
</ol>
<b><p>Element Type:</p></b>
<c:forEach items="${element_type}" var="element_type">
    <ul>
    <li><c:out value="${element_type.elementType}"/></li>
    <li><c:out value="${element_type.elementTypeDesc}"/></li>
    </ul>
</c:forEach>
</body>
</html>