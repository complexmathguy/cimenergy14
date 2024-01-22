import React, { Component } from 'react'
import GeographicalLocationVersionService from '../services/GeographicalLocationVersionService';

class CreateGeographicalLocationVersionComponent extends Component {
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
            GeographicalLocationVersionService.getGeographicalLocationVersionById(this.state.id).then( (res) =>{
                let geographicalLocationVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGeographicalLocationVersion = (e) => {
        e.preventDefault();
        let geographicalLocationVersion = {
                geographicalLocationVersionId: this.state.id,
            };
        console.log('geographicalLocationVersion => ' + JSON.stringify(geographicalLocationVersion));

        // step 5
        if(this.state.id === '_add'){
            geographicalLocationVersion.geographicalLocationVersionId=''
            GeographicalLocationVersionService.createGeographicalLocationVersion(geographicalLocationVersion).then(res =>{
                this.props.history.push('/geographicalLocationVersions');
            });
        }else{
            GeographicalLocationVersionService.updateGeographicalLocationVersion(geographicalLocationVersion).then( res => {
                this.props.history.push('/geographicalLocationVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/geographicalLocationVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GeographicalLocationVersion</h3>
        }else{
            return <h3 className="text-center">Update GeographicalLocationVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGeographicalLocationVersion}>Save</button>
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

export default CreateGeographicalLocationVersionComponent
