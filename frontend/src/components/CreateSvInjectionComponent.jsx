import React, { Component } from 'react'
import SvInjectionService from '../services/SvInjectionService';

class CreateSvInjectionComponent extends Component {
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
            SvInjectionService.getSvInjectionById(this.state.id).then( (res) =>{
                let svInjection = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSvInjection = (e) => {
        e.preventDefault();
        let svInjection = {
                svInjectionId: this.state.id,
            };
        console.log('svInjection => ' + JSON.stringify(svInjection));

        // step 5
        if(this.state.id === '_add'){
            svInjection.svInjectionId=''
            SvInjectionService.createSvInjection(svInjection).then(res =>{
                this.props.history.push('/svInjections');
            });
        }else{
            SvInjectionService.updateSvInjection(svInjection).then( res => {
                this.props.history.push('/svInjections');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/svInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvInjection</h3>
        }else{
            return <h3 className="text-center">Update SvInjection</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvInjection}>Save</button>
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

export default CreateSvInjectionComponent
