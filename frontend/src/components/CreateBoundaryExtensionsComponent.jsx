import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService';

class CreateBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( (res) =>{
                let boundaryExtensions = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateBoundaryExtensions = (e) => {
        e.preventDefault();
        let boundaryExtensions = {
                boundaryExtensionsId: this.state.id,
            };
        console.log('boundaryExtensions => ' + JSON.stringify(boundaryExtensions));

        // step 5
        if(this.state.id === '_add'){
            boundaryExtensions.boundaryExtensionsId=''
            BoundaryExtensionsService.createBoundaryExtensions(boundaryExtensions).then(res =>{
                this.props.history.push('/boundaryExtensionss');
            });
        }else{
            BoundaryExtensionsService.updateBoundaryExtensions(boundaryExtensions).then( res => {
                this.props.history.push('/boundaryExtensionss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/boundaryExtensionss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BoundaryExtensions</h3>
        }else{
            return <h3 className="text-center">Update BoundaryExtensions</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBoundaryExtensions}>Save</button>
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

export default CreateBoundaryExtensionsComponent
