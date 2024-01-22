import React, { Component } from 'react'
import SvShuntCompensatorSectionsService from '../services/SvShuntCompensatorSectionsService';

class UpdateSvShuntCompensatorSectionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSvShuntCompensatorSections = this.updateSvShuntCompensatorSections.bind(this);

    }

    componentDidMount(){
        SvShuntCompensatorSectionsService.getSvShuntCompensatorSectionsById(this.state.id).then( (res) =>{
            let svShuntCompensatorSections = res.data;
            this.setState({
            });
        });
    }

    updateSvShuntCompensatorSections = (e) => {
        e.preventDefault();
        let svShuntCompensatorSections = {
            svShuntCompensatorSectionsId: this.state.id,
        };
        console.log('svShuntCompensatorSections => ' + JSON.stringify(svShuntCompensatorSections));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvShuntCompensatorSectionsService.updateSvShuntCompensatorSections(svShuntCompensatorSections).then( res => {
            this.props.history.push('/svShuntCompensatorSectionss');
        });
    }


    cancel(){
        this.props.history.push('/svShuntCompensatorSectionss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvShuntCompensatorSections</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvShuntCompensatorSections}>Save</button>
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

export default UpdateSvShuntCompensatorSectionsComponent
