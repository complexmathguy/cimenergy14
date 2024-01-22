import React, { Component } from 'react'
import PhaseTapChangerLinearService from '../services/PhaseTapChangerLinearService';

class UpdatePhaseTapChangerLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChangerLinear = this.updatePhaseTapChangerLinear.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerLinearService.getPhaseTapChangerLinearById(this.state.id).then( (res) =>{
            let phaseTapChangerLinear = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChangerLinear = (e) => {
        e.preventDefault();
        let phaseTapChangerLinear = {
            phaseTapChangerLinearId: this.state.id,
        };
        console.log('phaseTapChangerLinear => ' + JSON.stringify(phaseTapChangerLinear));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerLinearService.updatePhaseTapChangerLinear(phaseTapChangerLinear).then( res => {
            this.props.history.push('/phaseTapChangerLinears');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangerLinears');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerLinear</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerLinear}>Save</button>
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

export default UpdatePhaseTapChangerLinearComponent
