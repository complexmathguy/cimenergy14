import React, { Component } from 'react'
import GeographicalLocationVersionService from '../services/GeographicalLocationVersionService';

class UpdateGeographicalLocationVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGeographicalLocationVersion = this.updateGeographicalLocationVersion.bind(this);

    }

    componentDidMount(){
        GeographicalLocationVersionService.getGeographicalLocationVersionById(this.state.id).then( (res) =>{
            let geographicalLocationVersion = res.data;
            this.setState({
            });
        });
    }

    updateGeographicalLocationVersion = (e) => {
        e.preventDefault();
        let geographicalLocationVersion = {
            geographicalLocationVersionId: this.state.id,
        };
        console.log('geographicalLocationVersion => ' + JSON.stringify(geographicalLocationVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        GeographicalLocationVersionService.updateGeographicalLocationVersion(geographicalLocationVersion).then( res => {
            this.props.history.push('/geographicalLocationVersions');
        });
    }


    cancel(){
        this.props.history.push('/geographicalLocationVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GeographicalLocationVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGeographicalLocationVersion}>Save</button>
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

export default UpdateGeographicalLocationVersionComponent
