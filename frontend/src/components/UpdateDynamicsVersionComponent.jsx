import React, { Component } from 'react'
import DynamicsVersionService from '../services/DynamicsVersionService';

class UpdateDynamicsVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDynamicsVersion = this.updateDynamicsVersion.bind(this);

    }

    componentDidMount(){
        DynamicsVersionService.getDynamicsVersionById(this.state.id).then( (res) =>{
            let dynamicsVersion = res.data;
            this.setState({
            });
        });
    }

    updateDynamicsVersion = (e) => {
        e.preventDefault();
        let dynamicsVersion = {
            dynamicsVersionId: this.state.id,
        };
        console.log('dynamicsVersion => ' + JSON.stringify(dynamicsVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        DynamicsVersionService.updateDynamicsVersion(dynamicsVersion).then( res => {
            this.props.history.push('/dynamicsVersions');
        });
    }


    cancel(){
        this.props.history.push('/dynamicsVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DynamicsVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDynamicsVersion}>Save</button>
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

export default UpdateDynamicsVersionComponent
