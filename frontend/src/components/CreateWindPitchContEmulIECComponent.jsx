import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService';

class CreateWindPitchContEmulIECComponent extends Component {
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
            WindPitchContEmulIECService.getWindPitchContEmulIECById(this.state.id).then( (res) =>{
                let windPitchContEmulIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPitchContEmulIEC = (e) => {
        e.preventDefault();
        let windPitchContEmulIEC = {
                windPitchContEmulIECId: this.state.id,
            };
        console.log('windPitchContEmulIEC => ' + JSON.stringify(windPitchContEmulIEC));

        // step 5
        if(this.state.id === '_add'){
            windPitchContEmulIEC.windPitchContEmulIECId=''
            WindPitchContEmulIECService.createWindPitchContEmulIEC(windPitchContEmulIEC).then(res =>{
                this.props.history.push('/windPitchContEmulIECs');
            });
        }else{
            WindPitchContEmulIECService.updateWindPitchContEmulIEC(windPitchContEmulIEC).then( res => {
                this.props.history.push('/windPitchContEmulIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPitchContEmulIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPitchContEmulIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPitchContEmulIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPitchContEmulIEC}>Save</button>
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

export default CreateWindPitchContEmulIECComponent
