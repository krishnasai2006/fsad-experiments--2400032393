
import React from "react";
import StudentList from "./StudentList";
import AddStudent from "./AddStudent";

function App(){
 return(
  <div>
   <h1>Student Management System</h1>
   <AddStudent/>
   <StudentList/>
  </div>
 );
}

export default App;
