import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service';

class CreateTurbLCFB1Component extends Component {
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
            TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( (res) =>{
                let turbLCFB1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTurbLCFB1 = (e) => {
        e.preventDefault();
        let turbLCFB1 = {
                turbLCFB1Id: this.state.id,
            };
        console.log('turbLCFB1 => ' + JSON.stringify(turbLCFB1));

        // step 5
        if(this.state.id === '_add'){
            turbLCFB1.turbLCFB1Id=''
            TurbLCFB1Service.createTurbLCFB1(turbLCFB1).then(res =>{
                this.props.history.push('/turbLCFB1s');
            });
        }else{
            TurbLCFB1Service.updateTurbLCFB1(turbLCFB1).then( res => {
                this.props.history.push('/turbLCFB1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/turbLCFB1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbLCFB1</h3>
        }else{
            return <h3 className="text-center">Update TurbLCFB1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbLCFB1}>Save</button>
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

export default CreateTurbLCFB1Component
