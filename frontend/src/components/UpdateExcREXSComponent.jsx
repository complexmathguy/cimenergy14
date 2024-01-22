import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService';

class UpdateExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                fbf: ''
        }
        this.updateExcREXS = this.updateExcREXS.bind(this);

        this.changeFbfHandler = this.changeFbfHandler.bind(this);
    }

    componentDidMount(){
        ExcREXSService.getExcREXSById(this.state.id).then( (res) =>{
            let excREXS = res.data;
            this.setState({
                fbf: excREXS.fbf
            });
        });
    }

    updateExcREXS = (e) => {
        e.preventDefault();
        let excREXS = {
            excREXSId: this.state.id,
            fbf: this.state.fbf
        };
        console.log('excREXS => ' + JSON.stringify(excREXS));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcREXSService.updateExcREXS(excREXS).then( res => {
            this.props.history.push('/excREXSs');
        });
    }

    changeFbfHandler= (event) => {
        this.setState({fbf: event.target.value});
    }

    cancel(){
        this.props.history.push('/excREXSs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcREXS</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Fbf: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcREXS}>Save</button>
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

export default UpdateExcREXSComponent
