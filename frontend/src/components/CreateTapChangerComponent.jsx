import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService';

class CreateTapChangerComponent extends Component {
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
            TapChangerService.getTapChangerById(this.state.id).then( (res) =>{
                let tapChanger = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTapChanger = (e) => {
        e.preventDefault();
        let tapChanger = {
                tapChangerId: this.state.id,
            };
        console.log('tapChanger => ' + JSON.stringify(tapChanger));

        // step 5
        if(this.state.id === '_add'){
            tapChanger.tapChangerId=''
            TapChangerService.createTapChanger(tapChanger).then(res =>{
                this.props.history.push('/tapChangers');
            });
        }else{
            TapChangerService.updateTapChanger(tapChanger).then( res => {
                this.props.history.push('/tapChangers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/tapChangers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapChanger</h3>
        }else{
            return <h3 className="text-center">Update TapChanger</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapChanger}>Save</button>
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

export default CreateTapChangerComponent
