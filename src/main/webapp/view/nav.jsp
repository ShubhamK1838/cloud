<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.Base64" %>
<%@ page import="com.cloud.model.entity.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/auth/form"); // Redirect to login page if user is not logged in
        return;
    }
%>
<header class="navbar">
    <div class="navbar-brand">
        <img src="/profile/logo.png" alt="Logo" class="logo">
        <span> CloudFileServer</span>
    </div>
    <nav class="navbar-nav">
        <a href="/home">Home</a>
        <a href="/upload">Upload</a>
        <a href="/myfiles">File</a>
        <a href="/settings">Setting</a>
        <a href="/logout">Logout</a>
    </nav>
    <div class="user-profile">
        <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(user.getImageData()) %>" alt="User Image" class="user-image">
        <span class="user-name"><%= "" %></span>
    </div>
</header>
