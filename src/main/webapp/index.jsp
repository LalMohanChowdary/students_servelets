<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Marks</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-wrapper {
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        width: 90%;
        gap: 20px;
        padding: 20px;
        box-sizing: border-box;
    }

    /* Specific styles for Insert Record Form */
    .insert-record-form {
        background-color: #f9f9f9;
        border: 1px solid #ddd;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 250px;
        margin-bottom: 20px;
        transition: transform 0.3s ease;
    }

    .insert-record-form:hover {
        transform: scale(1.05);
    }

    /* Specific styles for View Record Form */
    .view-record-form {
        background-color: #e3f2fd;
        border: 1px solid #bbdefb;
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 250px;
        margin-bottom: 20px;
        transition: transform 0.3s ease;
    }

    .view-record-form:hover {
        transform: scale(1.05);
    }

    /* Specific styles for Update Record Form */
    .update-record-form {
        background-color: #fff3e0;
        border: 1px solid #ffccbc;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 250px;
        margin-bottom: 20px;
        transition: transform 0.3s ease;
    }

    .update-record-form:hover {
        transform: scale(1.05);
    }

    /* Specific styles for Delete Record Form */
    .delete-record-form {
        background-color: #ffebee;
        border: 1px solid #ffcdd2;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 250px;
        margin-bottom: 20px;
        transition: transform 0.3s ease;
    }

    .delete-record-form:hover {
        transform: scale(1.05);
    }

    /* Common styles for form elements */
    .form-common input[type="text"],
    .form-common input[type="submit"],
    .form-common input[type="button"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        box-sizing: border-box;
        border-radius: 5px;
        font-size: 14px;
    }

    .form-common input[type="text"] {
        border: 1px solid #ccc;
        transition: border-color 0.3s ease;
    }

    .form-common input[type="text"]:focus {
        border-color: #009879;
        outline: none;
    }

    .form-common input[type="submit"] {
        background-color: #009879;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }

    .form-common input[type="submit"]:hover {
        background-color: #007a63;
        transform: scale(1.05);
    }

    .form-common input[type="button"] {
        background-color: #f0f0f0;
        color: #333;
        border: 1px solid #ccc;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }

    .form-common input[type="button"]:hover {
        background-color: #e0e0e0;
        transform: scale(1.05);
    }

    .form-common label {
        font-size: 14px;
        color: #333;
        display: block;
        margin-bottom: 5px;
    }

    .form-common .error-message {
        color: red;
        font-size: 12px;
        display: none;
    }
</style>
<script>
    function validateForm(formId) {
        let form = document.getElementById(formId);
        let inputs = form.getElementsByTagName('input');
        let valid = true;
        
        for (let input of inputs) {
            let errorMsg = document.getElementById(input.id + "-error");
            if (input.type === "text" && input.value.trim() === "") {
                errorMsg.style.display = "block";
                valid = false;
            } else {
                errorMsg.style.display = "none";
            }
        }
        return valid;
    }

    function resetForm(formId) {
        let form = document.getElementById(formId);
        form.reset();
        let errorMessages = form.getElementsByClassName('error-message');
        for (let msg of errorMessages) {
            msg.style.display = "none";
        }
    }
</script>
</head>
<body>

<div class="form-wrapper">
    <!-- Insert Record Form -->
    <form id="form-1" action="insertdata" method="post" class="insert-record-form form-common" onsubmit="return validateForm('form-1')">
        <h1>Insert Record</h1>
        <label for="input-1">Roll no:</label>
        <input id="input-1" placeholder="Enter Roll no" type="text" name="rollno" required/>
        <div id="input-1-error" class="error-message">Roll no is required.</div>
        
        <label for="input-2">Name:</label>
        <input id="input-2" placeholder="Enter Name" type="text" name="name" required/>
        <div id="input-2-error" class="error-message">Name is required.</div>
        
        <label for="input-3">Telugu:</label>
        <input id="input-3" placeholder="Enter Telugu Marks" type="text" name="tel" required/>
        <div id="input-3-error" class="error-message">Telugu marks are required.</div>
        
        <label for="input-4">Hindi:</label>
        <input id="input-4" placeholder="Enter Hindi Marks" type="text" name="hin" required />
        <div id="input-4-error" class="error-message">Hindi marks are required.</div>
        
        <label for="input-5">English:</label>
        <input id="input-5" placeholder="Enter English Marks" type="text" name="eng" required/>
        <div id="input-5-error" class="error-message">English marks are required.</div>
        
        <label for="input-6">Math:</label>
        <input id="input-6" placeholder="Enter Math Marks" type="text" name="math" required/>
        <div id="input-6-error" class="error-message">Math marks are required.</div>
        
        <label for="input-7">Science:</label>
        <input id="input-7" placeholder="Enter Science Marks" type="text" name="sci" required/>
        <div id="input-7-error" class="error-message">Science marks are required.</div>
        
        <label for="input-8">Social:</label>
        <input id="input-8" placeholder="Enter Social Marks" type="text" name="soci" required/>
        <div id="input-8-error" class="error-message">Social marks are required.</div>
        
        <input type="submit" value="Insert Data" id="button-1"/>
        <input type="button" value="Reset Form" onclick="resetForm('form-1')" />
    </form>

    <!-- View Record Form -->
    <form id="form-2" action="viewdata" method="get" class="view-record-form form-common" onsubmit="return validateForm('form-2')">
        <h1>View Records</h1>
        
        <label for="input-9">Enter Roll No:</label>
        <input id="input-9" placeholder="Enter Roll No" type="text" name="roll" required/>
        <div id="input-9-error" class="error-message">Roll no is required.</div>
        
        <input type="submit" value="View Data" id="button-2"/>
        <input type="button" value="Reset Form" onclick="resetForm('form-2')" />
    </form>

    <!-- Update Record Form -->
    <form id="form-3" action="updatedata" method="post" class="update-record-form form-common" onsubmit="return validateForm('form-3')">
        <h1>Update Record</h1>
        
        <label for="input-10">Roll No:</label>
        <input id="input-10" placeholder="Enter Roll No" type="text" name="rollno" required/>
        <div id="input-10-error" class="error-message">Roll no is required.</div>
        
        <label for="input-11">Name:</label>
        <input id="input-11" placeholder="Enter New Name" type="text" name="name"/>
        
        <label for="input-12">Telugu:</label>
        <input id="input-12" placeholder="Enter New Telugu Marks" type="text" name="tel"/>
        
        <label for="input-13">Hindi:</label>
        <input id="input-13" placeholder="Enter New Hindi Marks" type="text" name="hin"/>
        
        <label for="input-14">English:</label>
        <input id="input-14" placeholder="Enter New English Marks" type="text" name="eng"/>
        
        <label for="input-15">Math:</label>
        <input id="input-15" placeholder="Enter New Math Marks" type="text" name="math"/>
        
        <label for="input-16">Science:</label>
        <input id="input-16" placeholder="Enter New Science Marks" type="text" name="sci"/>
        
        <label for="input-17">Social:</label>
        <input id="input-17" placeholder="Enter New Social Marks" type="text" name="soci"/>
        
        <input type="submit" value="Update Data" id="button-3"/>
        <input type="button" value="Reset Form" onclick="resetForm('form-3')" />
    </form>

    <!-- Delete Record Form -->
    <form id="form-4" action="deletedata" method="post" class="delete-record-form form-common" onsubmit="return validateForm('form-4')">
        <h1>Delete Record</h1>
        
        <label for="input-18">Enter Roll No:</label>
        <input id="input-18" placeholder="Enter Roll No" type="text" name="rollno" required/>
        <div id="input-18-error" class="error-message">Roll no is required.</div>
        
        <input type="submit" value="Delete Data" id="button-4"/>
        <input type="button" value="Reset Form" onclick="resetForm('form-4')" />
    </form>
</div>

</body>
</html>
