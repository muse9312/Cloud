import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

function YoutubeInfo(props) {
  console.log('YoutubeInfo');
  return (
    <div class='container'>
      <img src={props.info.url}></img>
      <div>
        <p>{props.info.title}</p>
        <p>{props.info.desc}</p>
        <p>{props.info.videoId}</p>
      </div>
    </div>
  );
}
function App() {
  const [info, setInfo] = useState([]);

  useEffect(() => {
    const data = axios({
      url: 'https://www.googleapis.com/youtube/v3/search?part=snippet&q=슬기로운&maxResults=10&key=AIzaSyCM7VN_a33HR_6ehqD4__o5Qf6ZMxyLIg8',
      method: 'get'
    });
    data.then((result) => {
      const videoInfo = [];
      for(let item of result.data.items) {

        const title = item.snippet.title;
        const desc = item.snippet.description;
        const url = item.snippet.thumbnails.default.url;
        const videoId = item.id.videoId;
        // console.log(title, desc, url, videoId);
        videoInfo.push({title: title, desc: desc, url: url, videoId: videoId})
      }
      console.log(videoInfo);
      setInfo(videoInfo);
    });
  }, []);

  console.log(info);
  return (
    <div className="App">
      {info.map((v) => {
        return <YoutubeInfo info={v} key={v.videoId}/>
      })}
    </div>
  );
}

export default App;
