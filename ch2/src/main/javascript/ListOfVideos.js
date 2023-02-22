import React from "react"

class ListOfVideos extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: []}
    }

    async componentDidMount() {
        let json = (await fetch("/api/v1/videos")).json()
        this.setState({data: json})
    }


}
