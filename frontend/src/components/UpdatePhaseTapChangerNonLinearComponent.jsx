import React, { Component } from 'react'
import PhaseTapChangerNonLinearService from '../services/PhaseTapChangerNonLinearService';

class UpdatePhaseTapChangerNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChangerNonLinear = this.updatePhaseTapChangerNonLinear.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerNonLinearService.getPhaseTapChangerNonLinearById(this.state.id).then( (res) =>{
            let phaseTapChangerNonLinear = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChangerNonLinear = (e) => {
        e.preventDefault();
        let phaseTapChangerNonLinear = {
            phaseTapChangerNonLinearId: this.state.id,
        };
        console.log('phaseTapChangerNonLinear => ' + JSON.stringify(phaseTapChangerNonLinear));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerNonLinearService.updatePhaseTapChangerNonLinear(phaseTapChangerNonLinear).then( res => {
            this.props.history.push('/phaseTapChangerNonLinears');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangerNonLinears');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerNonLinear</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerNonLinear}>Save</button>
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

export default UpdatePhaseTapChangerNonLinearComponent
