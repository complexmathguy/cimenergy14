import React, { Component } from 'react'
import Quality61850Service from '../services/Quality61850Service';

class CreateQuality61850Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                source: '',
                validity: ''
        }
        this.changeSourceHandler = this.changeSourceHandler.bind(this);
        this.changeValidityHandler = this.changeValidityHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Quality61850Service.getQuality61850ById(this.state.id).then( (res) =>{
                let quality61850 = res.data;
                this.setState({
                    source: quality61850.source,
                    validity: quality61850.validity
                });
            });
        }        
    }
    saveOrUpdateQuality61850 = (e) => {
        e.preventDefault();
        let quality61850 = {
                quality61850Id: this.state.id,
                source: this.state.source,
                validity: this.state.validity
            };
        console.log('quality61850 => ' + JSON.stringify(quality61850));

        // step 5
        if(this.state.id === '_add'){
            quality61850.quality61850Id=''
            Quality61850Service.createQuality61850(quality61850).then(res =>{
                this.props.history.push('/quality61850s');
            });
        }else{
            Quality61850Service.updateQuality61850(quality61850).then( res => {
                this.props.history.push('/quality61850s');
            });
        }
    }
    
    changeSourceHandler= (event) => {
        this.setState({source: event.target.value});
    }
    changeValidityHandler= (event) => {
        this.setState({validity: event.target.value});
    }

    cancel(){
        this.props.history.push('/quality61850s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Quality61850</h3>
        }else{
            return <h3 className="text-center">Update Quality61850</h3>
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
                                            <label> Source: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Validity: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateQuality61850}>Save</button>
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

export default CreateQuality61850Component
