import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService';

class CreateWindContCurrLimIECComponent extends Component {
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
            WindContCurrLimIECService.getWindContCurrLimIECById(this.state.id).then( (res) =>{
                let windContCurrLimIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindContCurrLimIEC = (e) => {
        e.preventDefault();
        let windContCurrLimIEC = {
                windContCurrLimIECId: this.state.id,
            };
        console.log('windContCurrLimIEC => ' + JSON.stringify(windContCurrLimIEC));

        // step 5
        if(this.state.id === '_add'){
            windContCurrLimIEC.windContCurrLimIECId=''
            WindContCurrLimIECService.createWindContCurrLimIEC(windContCurrLimIEC).then(res =>{
                this.props.history.push('/windContCurrLimIECs');
            });
        }else{
            WindContCurrLimIECService.updateWindContCurrLimIEC(windContCurrLimIEC).then( res => {
                this.props.history.push('/windContCurrLimIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windContCurrLimIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContCurrLimIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContCurrLimIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContCurrLimIEC}>Save</button>
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

export default CreateWindContCurrLimIECComponent
