import React, { Component } from 'react'
import DomainVersionService from '../services/DomainVersionService';

class CreateDomainVersionComponent extends Component {
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
            DomainVersionService.getDomainVersionById(this.state.id).then( (res) =>{
                let domainVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDomainVersion = (e) => {
        e.preventDefault();
        let domainVersion = {
                domainVersionId: this.state.id,
            };
        console.log('domainVersion => ' + JSON.stringify(domainVersion));

        // step 5
        if(this.state.id === '_add'){
            domainVersion.domainVersionId=''
            DomainVersionService.createDomainVersion(domainVersion).then(res =>{
                this.props.history.push('/domainVersions');
            });
        }else{
            DomainVersionService.updateDomainVersion(domainVersion).then( res => {
                this.props.history.push('/domainVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/domainVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DomainVersion</h3>
        }else{
            return <h3 className="text-center">Update DomainVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDomainVersion}>Save</button>
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

export default CreateDomainVersionComponent
