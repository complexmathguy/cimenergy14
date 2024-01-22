import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService'

class ViewLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadComposite: {}
        }
    }

    componentDidMount(){
        LoadCompositeService.getLoadCompositeById(this.state.id).then( res => {
            this.setState({loadComposite: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadComposite Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadCompositeComponent
