function loadBlog(page, append) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog?search`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderBlogs(data.content, append);
            renderLoadMoreButton(data);
        },
        error: function (error) {
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