import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService';

class CreateExcANSComponent extends Component {
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
            ExcANSService.getExcANSById(this.state.id).then( (res) =>{
                let excANS = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcANS = (e) => {
        e.preventDefault();
        let excANS = {
                excANSId: this.state.id,
            };
        console.log('excANS => ' + JSON.stringify(excANS));

        // step 5
        if(this.state.id === '_add'){
            excANS.excANSId=''
            ExcANSService.createExcANS(excANS).then(res =>{
                this.props.history.push('/excANSs');
            });
        }else{
            ExcANSService.updateExcANS(excANS).then( res => {
                this.props.history.push('/excANSs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excANSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcANS</h3>
        }else{
            return <h3 className="text-center">Update ExcANS</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcANS}>Save</button>
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

export default CreateExcANSComponent
