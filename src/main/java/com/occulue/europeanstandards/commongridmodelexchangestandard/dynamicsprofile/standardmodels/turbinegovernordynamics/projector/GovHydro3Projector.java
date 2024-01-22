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
 * Projector for GovHydro3 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydro3 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydro3Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydro3")
@Component("govHydro3-projector")
public class GovHydro3Projector extends GovHydro3EntityProjector {

  // core constructor
  public GovHydro3Projector(GovHydro3Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydro3Event
   */
  @EventHandler(payloadType = CreateGovHydro3Event.class)
  public void handle(CreateGovHydro3Event event) {
    LOGGER.info("handling CreateGovHydro3Event - " + event);
    GovHydro3 entity = new GovHydro3();
    entity.setGovHydro3Id(event.getGovHydro3Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UpdateGovHydro3Event
   */
  @EventHandler(payloadType = UpdateGovHydro3Event.class)
  public void handle(UpdateGovHydro3Event event) {
    LOGGER.info("handling UpdateGovHydro3Event - " + event);

    GovHydro3 entity = new GovHydro3();
    entity.setGovHydro3Id(event.getGovHydro3Id());
    entity.setAt(event.getAt());
    entity.setDb1(event.getDb1());
    entity.setDb2(event.getDb2());
    entity.setDturb(event.getDturb());
    entity.setEps(event.getEps());
    entity.setGovernorControl(event.getGovernorControl());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setH0(event.getH0());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setQnl(event.getQnl());
    entity.setRelec(event.getRelec());
    entity.setRgate(event.getRgate());
    entity.setTd(event.getTd());
    entity.setTf(event.getTf());
    entity.setTp(event.getTp());
    entity.setTt(event.getTt());
    entity.setTw(event.getTw());
    entity.setVelcl(event.getVelcl());
    entity.setVelop(event.getVelop());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event DeleteGovHydro3Event
   */
  @EventHandler(payloadType = DeleteGovHydro3Event.class)
  public void handle(DeleteGovHydro3Event event) {
    LOGGER.info("handling DeleteGovHydro3Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydro3 entity = delete(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignAtToGovHydro3Event
   */
  @EventHandler(payloadType = AssignAtToGovHydro3Event.class)
  public void handle(AssignAtToGovHydro3Event event) {
    LOGGER.info("handling AssignAtToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignAt(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignAtFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignAtFromGovHydro3Event.class)
  public void handle(UnAssignAtFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignAtFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignAt(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignDb1ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignDb1ToGovHydro3Event.class)
  public void handle(AssignDb1ToGovHydro3Event event) {
    LOGGER.info("handling AssignDb1ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignDb1(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignDb1FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignDb1FromGovHydro3Event.class)
  public void handle(UnAssignDb1FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignDb1FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignDb1(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignDb2ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignDb2ToGovHydro3Event.class)
  public void handle(AssignDb2ToGovHydro3Event event) {
    LOGGER.info("handling AssignDb2ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignDb2(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignDb2FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignDb2FromGovHydro3Event.class)
  public void handle(UnAssignDb2FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignDb2FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignDb2(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignDturbToGovHydro3Event
   */
  @EventHandler(payloadType = AssignDturbToGovHydro3Event.class)
  public void handle(AssignDturbToGovHydro3Event event) {
    LOGGER.info("handling AssignDturbToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignDturb(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignDturbFromGovHydro3Event.class)
  public void handle(UnAssignDturbFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignDturbFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignDturb(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignEpsToGovHydro3Event
   */
  @EventHandler(payloadType = AssignEpsToGovHydro3Event.class)
  public void handle(AssignEpsToGovHydro3Event event) {
    LOGGER.info("handling AssignEpsToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignEps(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignEpsFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignEpsFromGovHydro3Event.class)
  public void handle(UnAssignEpsFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignEpsFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignEps(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGovernorControlToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGovernorControlToGovHydro3Event.class)
  public void handle(AssignGovernorControlToGovHydro3Event event) {
    LOGGER.info("handling AssignGovernorControlToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGovernorControl(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGovernorControlFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGovernorControlFromGovHydro3Event.class)
  public void handle(UnAssignGovernorControlFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGovernorControlFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGovernorControl(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv1ToGovHydro3Event.class)
  public void handle(AssignGv1ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv1ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv1(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydro3Event.class)
  public void handle(UnAssignGv1FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv1FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv1(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv2ToGovHydro3Event.class)
  public void handle(AssignGv2ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv2ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv2(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydro3Event.class)
  public void handle(UnAssignGv2FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv2FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv2(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv3ToGovHydro3Event.class)
  public void handle(AssignGv3ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv3ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv3(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydro3Event.class)
  public void handle(UnAssignGv3FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv3FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv3(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv4ToGovHydro3Event.class)
  public void handle(AssignGv4ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv4ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv4(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydro3Event.class)
  public void handle(UnAssignGv4FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv4FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv4(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv5ToGovHydro3Event.class)
  public void handle(AssignGv5ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv5ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv5(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydro3Event.class)
  public void handle(UnAssignGv5FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv5FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv5(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignGv6ToGovHydro3Event.class)
  public void handle(AssignGv6ToGovHydro3Event event) {
    LOGGER.info("handling AssignGv6ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignGv6(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydro3Event.class)
  public void handle(UnAssignGv6FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignGv6FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignGv6(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignH0ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignH0ToGovHydro3Event.class)
  public void handle(AssignH0ToGovHydro3Event event) {
    LOGGER.info("handling AssignH0ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignH0(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignH0FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignH0FromGovHydro3Event.class)
  public void handle(UnAssignH0FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignH0FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignH0(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignK1ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignK1ToGovHydro3Event.class)
  public void handle(AssignK1ToGovHydro3Event event) {
    LOGGER.info("handling AssignK1ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignK1(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignK1FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignK1FromGovHydro3Event.class)
  public void handle(UnAssignK1FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignK1FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignK1(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignK2ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignK2ToGovHydro3Event.class)
  public void handle(AssignK2ToGovHydro3Event event) {
    LOGGER.info("handling AssignK2ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignK2(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignK2FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignK2FromGovHydro3Event.class)
  public void handle(UnAssignK2FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignK2FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignK2(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignKgToGovHydro3Event
   */
  @EventHandler(payloadType = AssignKgToGovHydro3Event.class)
  public void handle(AssignKgToGovHydro3Event event) {
    LOGGER.info("handling AssignKgToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignKg(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignKgFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignKgFromGovHydro3Event.class)
  public void handle(UnAssignKgFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignKgFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignKg(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignKiToGovHydro3Event
   */
  @EventHandler(payloadType = AssignKiToGovHydro3Event.class)
  public void handle(AssignKiToGovHydro3Event event) {
    LOGGER.info("handling AssignKiToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignKi(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydro3Event.class)
  public void handle(UnAssignKiFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignKiFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignKi(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydro3Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydro3Event.class)
  public void handle(AssignMwbaseToGovHydro3Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignMwbase(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydro3Event.class)
  public void handle(UnAssignMwbaseFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignMwbase(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydro3Event.class)
  public void handle(AssignPgv1ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv1ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv1(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydro3Event.class)
  public void handle(UnAssignPgv1FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv1(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydro3Event.class)
  public void handle(AssignPgv2ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv2ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv2(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydro3Event.class)
  public void handle(UnAssignPgv2FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv2(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydro3Event.class)
  public void handle(AssignPgv3ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv3ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv3(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydro3Event.class)
  public void handle(UnAssignPgv3FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv3(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydro3Event.class)
  public void handle(AssignPgv4ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv4ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv4(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydro3Event.class)
  public void handle(UnAssignPgv4FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv4(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydro3Event.class)
  public void handle(AssignPgv5ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv5ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv5(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydro3Event.class)
  public void handle(UnAssignPgv5FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv5(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydro3Event.class)
  public void handle(AssignPgv6ToGovHydro3Event event) {
    LOGGER.info("handling AssignPgv6ToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPgv6(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydro3Event.class)
  public void handle(UnAssignPgv6FromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPgv6(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPmaxToGovHydro3Event.class)
  public void handle(AssignPmaxToGovHydro3Event event) {
    LOGGER.info("handling AssignPmaxToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPmax(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydro3Event.class)
  public void handle(UnAssignPmaxFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPmax(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignPminToGovHydro3Event
   */
  @EventHandler(payloadType = AssignPminToGovHydro3Event.class)
  public void handle(AssignPminToGovHydro3Event event) {
    LOGGER.info("handling AssignPminToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignPmin(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydro3Event.class)
  public void handle(UnAssignPminFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignPminFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignPmin(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignQnlToGovHydro3Event
   */
  @EventHandler(payloadType = AssignQnlToGovHydro3Event.class)
  public void handle(AssignQnlToGovHydro3Event event) {
    LOGGER.info("handling AssignQnlToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignQnl(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignQnlFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignQnlFromGovHydro3Event.class)
  public void handle(UnAssignQnlFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignQnlFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignQnl(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignRelecToGovHydro3Event
   */
  @EventHandler(payloadType = AssignRelecToGovHydro3Event.class)
  public void handle(AssignRelecToGovHydro3Event event) {
    LOGGER.info("handling AssignRelecToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignRelec(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignRelecFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignRelecFromGovHydro3Event.class)
  public void handle(UnAssignRelecFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignRelecFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignRelec(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignRgateToGovHydro3Event
   */
  @EventHandler(payloadType = AssignRgateToGovHydro3Event.class)
  public void handle(AssignRgateToGovHydro3Event event) {
    LOGGER.info("handling AssignRgateToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignRgate(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignRgateFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignRgateFromGovHydro3Event.class)
  public void handle(UnAssignRgateFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignRgateFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignRgate(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignTdToGovHydro3Event
   */
  @EventHandler(payloadType = AssignTdToGovHydro3Event.class)
  public void handle(AssignTdToGovHydro3Event event) {
    LOGGER.info("handling AssignTdToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignTd(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignTdFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignTdFromGovHydro3Event.class)
  public void handle(UnAssignTdFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignTdFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignTd(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignTfToGovHydro3Event
   */
  @EventHandler(payloadType = AssignTfToGovHydro3Event.class)
  public void handle(AssignTfToGovHydro3Event event) {
    LOGGER.info("handling AssignTfToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignTf(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignTfFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignTfFromGovHydro3Event.class)
  public void handle(UnAssignTfFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignTfFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignTf(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignTpToGovHydro3Event
   */
  @EventHandler(payloadType = AssignTpToGovHydro3Event.class)
  public void handle(AssignTpToGovHydro3Event event) {
    LOGGER.info("handling AssignTpToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignTp(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydro3Event.class)
  public void handle(UnAssignTpFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignTpFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignTp(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignTtToGovHydro3Event
   */
  @EventHandler(payloadType = AssignTtToGovHydro3Event.class)
  public void handle(AssignTtToGovHydro3Event event) {
    LOGGER.info("handling AssignTtToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignTt(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignTtFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignTtFromGovHydro3Event.class)
  public void handle(UnAssignTtFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignTtFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignTt(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignTwToGovHydro3Event
   */
  @EventHandler(payloadType = AssignTwToGovHydro3Event.class)
  public void handle(AssignTwToGovHydro3Event event) {
    LOGGER.info("handling AssignTwToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignTw(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydro3Event.class)
  public void handle(UnAssignTwFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignTw(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignVelclToGovHydro3Event
   */
  @EventHandler(payloadType = AssignVelclToGovHydro3Event.class)
  public void handle(AssignVelclToGovHydro3Event event) {
    LOGGER.info("handling AssignVelclToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignVelcl(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignVelclFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignVelclFromGovHydro3Event.class)
  public void handle(UnAssignVelclFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignVelclFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignVelcl(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event AssignVelopToGovHydro3Event
   */
  @EventHandler(payloadType = AssignVelopToGovHydro3Event.class)
  public void handle(AssignVelopToGovHydro3Event event) {
    LOGGER.info("handling AssignVelopToGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro3 entity = assignVelop(event.getGovHydro3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /*
   * @param	event UnAssignVelopFromGovHydro3Event
   */
  @EventHandler(payloadType = UnAssignVelopFromGovHydro3Event.class)
  public void handle(UnAssignVelopFromGovHydro3Event event) {
    LOGGER.info("handling UnAssignVelopFromGovHydro3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro3 entity = unAssignVelop(event.getGovHydro3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro3(entity);
  }

  /**
   * Method to retrieve the GovHydro3 via an GovHydro3PrimaryKey.
   *
   * @param id Long
   * @return GovHydro3
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydro3 handle(FindGovHydro3Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydro3Id());
  }

  /**
   * Method to retrieve a collection of all GovHydro3s
   *
   * @param query FindAllGovHydro3Query
   * @return List<GovHydro3>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydro3> handle(FindAllGovHydro3Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydro3, but only if the id matches
   *
   * @param entity GovHydro3
   */
  protected void emitFindGovHydro3(GovHydro3 entity) {
    LOGGER.info("handling emitFindGovHydro3");

    queryUpdateEmitter.emit(
        FindGovHydro3Query.class,
        query -> query.getFilter().getGovHydro3Id().equals(entity.getGovHydro3Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydro3
   *
   * @param entity GovHydro3
   */
  protected void emitFindAllGovHydro3(GovHydro3 entity) {
    LOGGER.info("handling emitFindAllGovHydro3");

    queryUpdateEmitter.emit(FindAllGovHydro3Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydro3Projector.class.getName());
}
