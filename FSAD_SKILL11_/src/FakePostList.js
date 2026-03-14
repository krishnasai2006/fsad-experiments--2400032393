import React,{useEffect,useState} from "react";
import axios from "axios";

function FakePostList(){

const [posts,setPosts] = useState([]);

const loadPosts = ()=>{

axios.get("https://dummyjson.com/posts")
.then(res=>setPosts(res.data.posts));

};

useEffect(()=>{
loadPosts();
},[]);

return(
<div>

<h2>Fake API Posts</h2>

<button onClick={loadPosts}>Refresh</button>

<ul>
{posts.slice(0,10).map(p=>(
<li key={p.id}>
<b>{p.title}</b>
<p>{p.body}</p>
</li>
))}
</ul>

</div>
);
}

export default FakePostList;
