import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service';

class CreateUnderexcLimIEEE2Component extends Component {
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
            UnderexcLimIEEE2Service.getUnderexcLimIEEE2ById(this.state.id).then( (res) =>{
                let underexcLimIEEE2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimIEEE2 = (e) => {
        e.preventDefault();
        let underexcLimIEEE2 = {
                underexcLimIEEE2Id: this.state.id,
            };
        console.log('underexcLimIEEE2 => ' + JSON.stringify(underexcLimIEEE2));

        // step 5
        if(this.state.id === '_add'){
            underexcLimIEEE2.underexcLimIEEE2Id=''
            UnderexcLimIEEE2Service.createUnderexcLimIEEE2(underexcLimIEEE2).then(res =>{
                this.props.history.push('/underexcLimIEEE2s');
            });
        }else{
            UnderexcLimIEEE2Service.updateUnderexcLimIEEE2(underexcLimIEEE2).then( res => {
                this.props.history.push('/underexcLimIEEE2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/underexcLimIEEE2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimIEEE2</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimIEEE2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimIEEE2}>Save</button>
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

export default CreateUnderexcLimIEEE2Component
