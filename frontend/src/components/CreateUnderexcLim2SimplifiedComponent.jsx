import React, { Component } from 'react'
import UnderexcLim2SimplifiedService from '../services/UnderexcLim2SimplifiedService';

class CreateUnderexcLim2SimplifiedComponent extends Component {
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
            UnderexcLim2SimplifiedService.getUnderexcLim2SimplifiedById(this.state.id).then( (res) =>{
                let underexcLim2Simplified = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcLim2Simplified = (e) => {
        e.preventDefault();
        let underexcLim2Simplified = {
                underexcLim2SimplifiedId: this.state.id,
            };
        console.log('underexcLim2Simplified => ' + JSON.stringify(underexcLim2Simplified));

        // step 5
        if(this.state.id === '_add'){
            underexcLim2Simplified.underexcLim2SimplifiedId=''
            UnderexcLim2SimplifiedService.createUnderexcLim2Simplified(underexcLim2Simplified).then(res =>{
                this.props.history.push('/underexcLim2Simplifieds');
            });
        }else{
            UnderexcLim2SimplifiedService.updateUnderexcLim2Simplified(underexcLim2Simplified).then( res => {
                this.props.history.push('/underexcLim2Simplifieds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcLim2Simplifieds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLim2Simplified</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLim2Simplified</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLim2Simplified}>Save</button>
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

export default CreateUnderexcLim2SimplifiedComponent
