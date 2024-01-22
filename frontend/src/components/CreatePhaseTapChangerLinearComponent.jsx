import React, { Component } from 'react'
import PhaseTapChangerLinearService from '../services/PhaseTapChangerLinearService';

class CreatePhaseTapChangerLinearComponent extends Component {
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
            PhaseTapChangerLinearService.getPhaseTapChangerLinearById(this.state.id).then( (res) =>{
                let phaseTapChangerLinear = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerLinear = (e) => {
        e.preventDefault();
        let phaseTapChangerLinear = {
                phaseTapChangerLinearId: this.state.id,
            };
        console.log('phaseTapChangerLinear => ' + JSON.stringify(phaseTapChangerLinear));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerLinear.phaseTapChangerLinearId=''
            PhaseTapChangerLinearService.createPhaseTapChangerLinear(phaseTapChangerLinear).then(res =>{
                this.props.history.push('/phaseTapChangerLinears');
            });
        }else{
            PhaseTapChangerLinearService.updatePhaseTapChangerLinear(phaseTapChangerLinear).then( res => {
                this.props.history.push('/phaseTapChangerLinears');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangerLinears');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerLinear</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerLinear</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerLinear}>Save</button>
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

export default CreatePhaseTapChangerLinearComponent
