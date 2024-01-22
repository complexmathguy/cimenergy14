import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService';

class UpdateBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateBoundaryExtensions = this.updateBoundaryExtensions.bind(this);

    }

    componentDidMount(){
        BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( (res) =>{
            let boundaryExtensions = res.data;
            this.setState({
            });
        });
    }

    updateBoundaryExtensions = (e) => {
        e.preventDefault();
        let boundaryExtensions = {
            boundaryExtensionsId: this.state.id,
        };
        console.log('boundaryExtensions => ' + JSON.stringify(boundaryExtensions));
        console.log('id => ' + JSON.stringify(this.state.id));
        BoundaryExtensionsService.updateBoundaryExtensions(boundaryExtensions).then( res => {
            this.props.history.push('/boundaryExtensionss');
        });
    }


    cancel(){
        this.props.history.push('/boundaryExtensionss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BoundaryExtensions</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBoundaryExtensions}>Save</button>
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

export default UpdateBoundaryExtensionsComponent
