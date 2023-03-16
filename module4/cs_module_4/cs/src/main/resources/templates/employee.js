function renderEmployee(employees , append){
    let elements = "";
    for (let employee of employees){
        elements += `
        <tr>
        <td>${employee.name}</td>
        <td>${employee.dateOfBirth}</td>
        <td>${employee.gender}</td>
        <td>${employee.address}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.levelEmployeeDTO.name}</td>
</tr>`
    }
    if (append){
        $("#listEmployee").append(elements);
    }else {
        $("#listEmployee").html(elements);
    }
}
function loadEmployee(page, append){
    let name = $("#name").val();
    $.ajax({
        type: "GET",
        url:
    })
}