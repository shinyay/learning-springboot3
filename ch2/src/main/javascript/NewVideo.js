import React from 'react'

class NewVideo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {name: ""}
    }

    handleChange(event) {
        this.setState({name: event.target.value})
    }
}
