function verifyPassword() {   
    var pw = document.getElementById("passingWord1").value; 
    var pw2 = document.getElementById("passingWord2").value; 

    if(pw.length < 6) {  
       document.getElementById("message").innerHTML = "Password must be at least 6 characters.";  

       return false;  
    }  
    
    if(pw.length > 15) {  
       document.getElementById("message").innerHTML = "Password must be no more than 15 characters.";  
       return false;  
    } 

    var pw1 = document.getElementById("passingWord1").value;
    var pw2 = document.getElementById("passingWord2").value;
    if(pw1 != pw2){

        document.getElementById("message").innerHTML = "Passwords didn't match!";
        return false;
    } else {
        document.getElementById("message").innerHTML = "Success! (Accounts coming soon)";
        return true;
    }
} 

