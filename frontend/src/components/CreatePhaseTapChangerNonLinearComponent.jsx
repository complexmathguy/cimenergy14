import React, { Component } from 'react'
import PhaseTapChangerNonLinearService from '../services/PhaseTapChangerNonLinearService';

class CreatePhaseTapChangerNonLinearComponent extends Component {
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
            PhaseTapChangerNonLinearService.getPhaseTapChangerNonLinearById(this.state.id).then( (res) =>{
                let phaseTapChangerNonLinear = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerNonLinear = (e) => {
        e.preventDefault();
        let phaseTapChangerNonLinear = {
                phaseTapChangerNonLinearId: this.state.id,
            };
        console.log('phaseTapChangerNonLinear => ' + JSON.stringify(phaseTapChangerNonLinear));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerNonLinear.phaseTapChangerNonLinearId=''
            PhaseTapChangerNonLinearService.createPhaseTapChangerNonLinear(phaseTapChangerNonLinear).then(res =>{
                this.props.history.push('/phaseTapChangerNonLinears');
            });
        }else{
            PhaseTapChangerNonLinearService.updatePhaseTapChangerNonLinear(phaseTapChangerNonLinear).then( res => {
                this.props.history.push('/phaseTapChangerNonLinears');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangerNonLinears');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerNonLinear</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerNonLinear</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerNonLinear}>Save</button>
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

export default CreatePhaseTapChangerNonLinearComponent
