import React, { Component } from 'react'
import Quality61850Service from '../services/Quality61850Service';

class UpdateQuality61850Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                source: '',
                validity: ''
        }
        this.updateQuality61850 = this.updateQuality61850.bind(this);

        this.changeSourceHandler = this.changeSourceHandler.bind(this);
        this.changeValidityHandler = this.changeValidityHandler.bind(this);
    }

    componentDidMount(){
        Quality61850Service.getQuality61850ById(this.state.id).then( (res) =>{
            let quality61850 = res.data;
            this.setState({
                source: quality61850.source,
                validity: quality61850.validity
            });
        });
    }

    updateQuality61850 = (e) => {
        e.preventDefault();
        let quality61850 = {
            quality61850Id: this.state.id,
            source: this.state.source,
            validity: this.state.validity
        };
        console.log('quality61850 => ' + JSON.stringify(quality61850));
        console.log('id => ' + JSON.stringify(this.state.id));
        Quality61850Service.updateQuality61850(quality61850).then( res => {
            this.props.history.push('/quality61850s');
        });
    }

    changeSourceHandler= (event) => {
        this.setState({source: event.target.value});
    }
    changeValidityHandler= (event) => {
        this.setState({validity: event.target.value});
    }

    cancel(){
        this.props.history.push('/quality61850s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Quality61850</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Source: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Validity: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateQuality61850}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateQuality61850Component
