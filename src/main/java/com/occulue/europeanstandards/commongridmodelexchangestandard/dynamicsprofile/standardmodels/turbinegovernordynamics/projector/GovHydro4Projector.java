/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovHydro4 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydro4 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydro4Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydro4")
@Component("govHydro4-projector")
public class GovHydro4Projector extends GovHydro4EntityProjector {

  // core constructor
  public GovHydro4Projector(GovHydro4Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydro4Event
   */
  @EventHandler(payloadType = CreateGovHydro4Event.class)
  public void handle(CreateGovHydro4Event event) {
    LOGGER.info("handling CreateGovHydro4Event - " + event);
    GovHydro4 entity = new GovHydro4();
    entity.setGovHydro4Id(event.getGovHydro4Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UpdateGovHydro4Event
   */
  @EventHandler(payloadType = UpdateGovHydro4Event.class)
  public void handle(UpdateGovHydro4Event event) {
    LOGGER.info("handling UpdateGovHydro4Event - " + event);

    GovHydro4 entity = new GovHydro4();
    entity.setGovHydro4Id(event.getGovHydro4Id());
    entity.setAt(event.getAt());
    entity.setBgv0(event.getBgv0());
    entity.setBgv1(event.getBgv1());
    entity.setBgv2(event.getBgv2());
    entity.setBgv3(event.getBgv3());
    entity.setBgv4(event.getBgv4());
    entity.setBgv5(event.getBgv5());
    entity.setBmax(event.getBmax());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setDturb(event.getDturb());
    entity.setEps(event.getEps());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setGv0(event.getGv0());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setHdam(event.getHdam());
    entity.setMwbase(event.getMwbase());
    entity.setPgv0(event.getPgv0());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setQn1(event.getQn1());
    entity.setRperm(event.getRperm());
    entity.setRtemp(event.getRtemp());
    entity.setTblade(event.getTblade());
    entity.setTg(event.getTg());
    entity.setTp(event.getTp());
    entity.setTr(event.getTr());
    entity.setTw(event.getTw());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event DeleteGovHydro4Event
   */
  @EventHandler(payloadType = DeleteGovHydro4Event.class)
  public void handle(DeleteGovHydro4Event event) {
    LOGGER.info("handling DeleteGovHydro4Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydro4 entity = delete(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignAtToGovHydro4Event
   */
  @EventHandler(payloadType = AssignAtToGovHydro4Event.class)
  public void handle(AssignAtToGovHydro4Event event) {
    LOGGER.info("handling AssignAtToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignAt(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignAtFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignAtFromGovHydro4Event.class)
  public void handle(UnAssignAtFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignAtFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignAt(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv0ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv0ToGovHydro4Event.class)
  public void handle(AssignBgv0ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv0ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv0(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv0FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv0FromGovHydro4Event.class)
  public void handle(UnAssignBgv0FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv0FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv0(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv1ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv1ToGovHydro4Event.class)
  public void handle(AssignBgv1ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv1ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv1(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv1FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv1FromGovHydro4Event.class)
  public void handle(UnAssignBgv1FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv1FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv1(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv2ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv2ToGovHydro4Event.class)
  public void handle(AssignBgv2ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv2ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv2(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv2FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv2FromGovHydro4Event.class)
  public void handle(UnAssignBgv2FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv2FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv2(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv3ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv3ToGovHydro4Event.class)
  public void handle(AssignBgv3ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv3ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv3(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv3FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv3FromGovHydro4Event.class)
  public void handle(UnAssignBgv3FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv3FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv3(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv4ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv4ToGovHydro4Event.class)
  public void handle(AssignBgv4ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv4ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv4(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv4FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv4FromGovHydro4Event.class)
  public void handle(UnAssignBgv4FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv4FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv4(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBgv5ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBgv5ToGovHydro4Event.class)
  public void handle(AssignBgv5ToGovHydro4Event event) {
    LOGGER.info("handling AssignBgv5ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBgv5(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBgv5FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBgv5FromGovHydro4Event.class)
  public void handle(UnAssignBgv5FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBgv5FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBgv5(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignBmaxToGovHydro4Event
   */
  @EventHandler(payloadType = AssignBmaxToGovHydro4Event.class)
  public void handle(AssignBmaxToGovHydro4Event event) {
    LOGGER.info("handling AssignBmaxToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignBmax(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignBmaxFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignBmaxFromGovHydro4Event.class)
  public void handle(UnAssignBmaxFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignBmaxFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignBmax(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignDb1ToGovHydro4Event.class)
  public void handle(AssignDb1ToGovHydro4Event event) {
    LOGGER.info("handling AssignDb1ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignDb1(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydro4Event.class)
  public void handle(UnAssignDb1FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignDb1FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignDb1(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignDb2ToGovHydro4Event.class)
  public void handle(AssignDb2ToGovHydro4Event event) {
    LOGGER.info("handling AssignDb2ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignDb2(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydro4Event.class)
  public void handle(UnAssignDb2FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignDb2FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignDb2(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignDturbToGovHydro4Event
   */
  @EventHandler(payloadType = AssignDturbToGovHydro4Event.class)
  public void handle(AssignDturbToGovHydro4Event event) {
    LOGGER.info("handling AssignDturbToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignDturb(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignDturbFromGovHydro4Event.class)
  public void handle(UnAssignDturbFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignDturbFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignDturb(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignEpsToGovHydro4Event
   */
  @EventHandler(payloadType = AssignEpsToGovHydro4Event.class)
  public void handle(AssignEpsToGovHydro4Event event) {
    LOGGER.info("handling AssignEpsToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignEps(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydro4Event.class)
  public void handle(UnAssignEpsFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignEpsFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignEps(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGmaxToGovHydro4Event.class)
  public void handle(AssignGmaxToGovHydro4Event event) {
    LOGGER.info("handling AssignGmaxToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGmax(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydro4Event.class)
  public void handle(UnAssignGmaxFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGmax(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGminToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGminToGovHydro4Event.class)
  public void handle(AssignGminToGovHydro4Event event) {
    LOGGER.info("handling AssignGminToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGmin(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydro4Event.class)
  public void handle(UnAssignGminFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGminFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGmin(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv0ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv0ToGovHydro4Event.class)
  public void handle(AssignGv0ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv0ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv0(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv0FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv0FromGovHydro4Event.class)
  public void handle(UnAssignGv0FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv0FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv0(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv1ToGovHydro4Event.class)
  public void handle(AssignGv1ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv1ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv1(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydro4Event.class)
  public void handle(UnAssignGv1FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv1FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv1(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv2ToGovHydro4Event.class)
  public void handle(AssignGv2ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv2ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv2(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydro4Event.class)
  public void handle(UnAssignGv2FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv2FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv2(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv3ToGovHydro4Event.class)
  public void handle(AssignGv3ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv3ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv3(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydro4Event.class)
  public void handle(UnAssignGv3FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv3FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv3(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv4ToGovHydro4Event.class)
  public void handle(AssignGv4ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv4ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv4(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydro4Event.class)
  public void handle(UnAssignGv4FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv4FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv4(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignGv5ToGovHydro4Event.class)
  public void handle(AssignGv5ToGovHydro4Event event) {
    LOGGER.info("handling AssignGv5ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignGv5(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydro4Event.class)
  public void handle(UnAssignGv5FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignGv5FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignGv5(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignHdamToGovHydro4Event
   */
  @EventHandler(payloadType = AssignHdamToGovHydro4Event.class)
  public void handle(AssignHdamToGovHydro4Event event) {
    LOGGER.info("handling AssignHdamToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignHdam(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignHdamFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignHdamFromGovHydro4Event.class)
  public void handle(UnAssignHdamFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignHdamFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignHdam(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydro4Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydro4Event.class)
  public void handle(AssignMwbaseToGovHydro4Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignMwbase(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydro4Event.class)
  public void handle(UnAssignMwbaseFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignMwbase(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv0ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv0ToGovHydro4Event.class)
  public void handle(AssignPgv0ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv0ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv0(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv0FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv0FromGovHydro4Event.class)
  public void handle(UnAssignPgv0FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv0FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv0(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydro4Event.class)
  public void handle(AssignPgv1ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv1ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv1(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydro4Event.class)
  public void handle(UnAssignPgv1FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv1(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydro4Event.class)
  public void handle(AssignPgv2ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv2ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv2(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydro4Event.class)
  public void handle(UnAssignPgv2FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv2(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydro4Event.class)
  public void handle(AssignPgv3ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv3ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv3(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydro4Event.class)
  public void handle(UnAssignPgv3FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv3(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydro4Event.class)
  public void handle(AssignPgv4ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv4ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv4(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydro4Event.class)
  public void handle(UnAssignPgv4FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv4(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydro4Event.class)
  public void handle(AssignPgv5ToGovHydro4Event event) {
    LOGGER.info("handling AssignPgv5ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignPgv5(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydro4Event.class)
  public void handle(UnAssignPgv5FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignPgv5(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignQn1ToGovHydro4Event
   */
  @EventHandler(payloadType = AssignQn1ToGovHydro4Event.class)
  public void handle(AssignQn1ToGovHydro4Event event) {
    LOGGER.info("handling AssignQn1ToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignQn1(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignQn1FromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignQn1FromGovHydro4Event.class)
  public void handle(UnAssignQn1FromGovHydro4Event event) {
    LOGGER.info("handling UnAssignQn1FromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignQn1(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignRpermToGovHydro4Event
   */
  @EventHandler(payloadType = AssignRpermToGovHydro4Event.class)
  public void handle(AssignRpermToGovHydro4Event event) {
    LOGGER.info("handling AssignRpermToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignRperm(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignRpermFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignRpermFromGovHydro4Event.class)
  public void handle(UnAssignRpermFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignRpermFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignRperm(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignRtempToGovHydro4Event
   */
  @EventHandler(payloadType = AssignRtempToGovHydro4Event.class)
  public void handle(AssignRtempToGovHydro4Event event) {
    LOGGER.info("handling AssignRtempToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignRtemp(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignRtempFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignRtempFromGovHydro4Event.class)
  public void handle(UnAssignRtempFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignRtempFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignRtemp(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignTbladeToGovHydro4Event
   */
  @EventHandler(payloadType = AssignTbladeToGovHydro4Event.class)
  public void handle(AssignTbladeToGovHydro4Event event) {
    LOGGER.info("handling AssignTbladeToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignTblade(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignTbladeFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignTbladeFromGovHydro4Event.class)
  public void handle(UnAssignTbladeFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignTbladeFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignTblade(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignTgToGovHydro4Event
   */
  @EventHandler(payloadType = AssignTgToGovHydro4Event.class)
  public void handle(AssignTgToGovHydro4Event event) {
    LOGGER.info("handling AssignTgToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignTg(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignTgFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignTgFromGovHydro4Event.class)
  public void handle(UnAssignTgFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignTgFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignTg(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignTpToGovHydro4Event
   */
  @EventHandler(payloadType = AssignTpToGovHydro4Event.class)
  public void handle(AssignTpToGovHydro4Event event) {
    LOGGER.info("handling AssignTpToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignTp(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydro4Event.class)
  public void handle(UnAssignTpFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignTpFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignTp(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignTrToGovHydro4Event
   */
  @EventHandler(payloadType = AssignTrToGovHydro4Event.class)
  public void handle(AssignTrToGovHydro4Event event) {
    LOGGER.info("handling AssignTrToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignTr(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignTrFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignTrFromGovHydro4Event.class)
  public void handle(UnAssignTrFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignTrFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignTr(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignTwToGovHydro4Event
   */
  @EventHandler(payloadType = AssignTwToGovHydro4Event.class)
  public void handle(AssignTwToGovHydro4Event event) {
    LOGGER.info("handling AssignTwToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignTw(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydro4Event.class)
  public void handle(UnAssignTwFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignTw(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignUcToGovHydro4Event
   */
  @EventHandler(payloadType = AssignUcToGovHydro4Event.class)
  public void handle(AssignUcToGovHydro4Event event) {
    LOGGER.info("handling AssignUcToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignUc(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignUcFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovHydro4Event.class)
  public void handle(UnAssignUcFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignUcFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignUc(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event AssignUoToGovHydro4Event
   */
  @EventHandler(payloadType = AssignUoToGovHydro4Event.class)
  public void handle(AssignUoToGovHydro4Event event) {
    LOGGER.info("handling AssignUoToGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro4 entity = assignUo(event.getGovHydro4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /*
   * @param	event UnAssignUoFromGovHydro4Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovHydro4Event.class)
  public void handle(UnAssignUoFromGovHydro4Event event) {
    LOGGER.info("handling UnAssignUoFromGovHydro4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro4 entity = unAssignUo(event.getGovHydro4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro4(entity);
  }

  /**
   * Method to retrieve the GovHydro4 via an GovHydro4PrimaryKey.
   *
   * @param id Long
   * @return GovHydro4
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydro4 handle(FindGovHydro4Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydro4Id());
  }

  /**
   * Method to retrieve a collection of all GovHydro4s
   *
   * @param query FindAllGovHydro4Query
   * @return List<GovHydro4>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydro4> handle(FindAllGovHydro4Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydro4, but only if the id matches
   *
   * @param entity GovHydro4
   */
  protected void emitFindGovHydro4(GovHydro4 entity) {
    LOGGER.info("handling emitFindGovHydro4");

    queryUpdateEmitter.emit(
        FindGovHydro4Query.class,
        query -> query.getFilter().getGovHydro4Id().equals(entity.getGovHydro4Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydro4
   *
   * @param entity GovHydro4
   */
  protected void emitFindAllGovHydro4(GovHydro4 entity) {
    LOGGER.info("handling emitFindAllGovHydro4");

    queryUpdateEmitter.emit(FindAllGovHydro4Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydro4Projector.class.getName());
}
