import React, { Component } from 'react'
import DCLineSegmentService from '../services/DCLineSegmentService';

class UpdateDCLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCLineSegment = this.updateDCLineSegment.bind(this);

    }

    componentDidMount(){
        DCLineSegmentService.getDCLineSegmentById(this.state.id).then( (res) =>{
            let dCLineSegment = res.data;
            this.setState({
            });
        });
    }

    updateDCLineSegment = (e) => {
        e.preventDefault();
        let dCLineSegment = {
            dCLineSegmentId: this.state.id,
        };
        console.log('dCLineSegment => ' + JSON.stringify(dCLineSegment));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCLineSegmentService.updateDCLineSegment(dCLineSegment).then( res => {
            this.props.history.push('/dCLineSegments');
        });
    }


    cancel(){
        this.props.history.push('/dCLineSegments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCLineSegment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCLineSegment}>Save</button>
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

export default UpdateDCLineSegmentComponent
