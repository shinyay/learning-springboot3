import React from 'react'

class NewVideo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {name: ""}
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event) {
        this.setState({name: event.target.value})
    }
}
