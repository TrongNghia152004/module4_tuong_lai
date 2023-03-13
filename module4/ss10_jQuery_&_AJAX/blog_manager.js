function loadBlog(page,append){
    let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog?page=${page ? page : "0"}&tittle=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            renderBlogs(data.content,append);
            renderLoadMoreButton(data);
        },
        error: function(error){
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadBlog();
})

function renderBlogs(blogs, append) {
    let elements = "";
    for (let blog of blogs) {
        elements += ` 
        <div class="card col-sm-3">
        <div class="card-body">
        <h5 class="card-title text-center">${blog.authorName}</h5>
        <p class="card-text">Title: ${blog.title}</p>
        <p class="card-text">Category: ${blog.categoryDTO.name}</p>
        <a href="#" class="btn btn-primary">Add card</a>
        </div>
</div>
        `
    }
    if (append) {
        $("#blogList").append(elements);
    } else {
        $("#blogList").html(elements);
    }
}
function loadMore(nextPage){
    loadBlog(nextPage,true);
}
function renderLoadMoreButton(blogPageData){
    if (blogPageData.number < blogPageData.totalPages - 1){
        $("#loadMoreContainer").html(
            `
            <button type="button" class="btn btn-secondary" onclick="loadMore(${blogPageData.number + 1})">
            Load more
</button>
           `
        );
    }else {
        $("#loadMoreContainer").remove();
    }
}
function loadMoreCategory(nextPage) {
    loadCategories(nextPage, true);
}

function renderLoadMoreCategoryBtn (categoryPageData) {
    if (categoryPageData.number < categoryPageData.totalPages -1) {
        $("#loadMoreCategoryContainer").html (
            `
                <button type="button" class="btn btn-primary"
                onclick="loadMoreCategory(${categoryPageData.number + 1})">
                Load More
                </button>
            `
        )
    } else {
        $("#loadMoreCategoryContainer").remove();
    }
}

function renderCategories (categories, append) {
    let elements = "";
    for (let category of categories) {
        elements +=
            `<tr>
        <td>${category.name}</td>
        <td>`
        for (let blogDTO of category.blogDTOSet) {
            elements +=
                blogDTO.title + `<br>`
        }
        `</td>
        </tr>`;
    }

    if (append) {
        $("#listCategories").append(elements);
    } else {
        $("#listCategories").html(elements);
    }
}

function loadCategories(page, append) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/category?page=${page ? page : "0"}`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderCategories(data.content, append)
            renderLoadMoreCategoryBtn(data)
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadCategories();
})