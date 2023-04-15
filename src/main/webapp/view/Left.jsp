<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="HomeServlet">Home</a></li>
					<li class="breadcrumb-item"><a href="#">Category</a></li>
					<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listC}" var="o">
						<li class="list-group-item black-white"><a style= "cursor: pointer;" onclick=load(${o.cid})>${o.cname}</a></li>
					</c:forEach>

				</ul>
			</div>
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">Last
					product</div>
				<div class="card-body">
					<img class="img-fluid" src="${lastestProcduct.image}" />
					<h5 class="card-title">${lastestProcduct.name}</h5>
					<p class="card-text">${lastestProcduct.title}</p>
					<p class="bloc_left_price">${lastestProcduct.price}$</p>
				</div>
			</div>
		</div>