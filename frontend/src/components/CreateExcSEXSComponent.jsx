import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService';

class CreateExcSEXSComponent extends Component {
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
            ExcSEXSService.getExcSEXSById(this.state.id).then( (res) =>{
                let excSEXS = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcSEXS = (e) => {
        e.preventDefault();
        let excSEXS = {
                excSEXSId: this.state.id,
            };
        console.log('excSEXS => ' + JSON.stringify(excSEXS));

        // step 5
        if(this.state.id === '_add'){
            excSEXS.excSEXSId=''
            ExcSEXSService.createExcSEXS(excSEXS).then(res =>{
                this.props.history.push('/excSEXSs');
            });
        }else{
            ExcSEXSService.updateExcSEXS(excSEXS).then( res => {
                this.props.history.push('/excSEXSs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excSEXSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcSEXS</h3>
        }else{
            return <h3 className="text-center">Update ExcSEXS</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcSEXS}>Save</button>
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

export default CreateExcSEXSComponent
