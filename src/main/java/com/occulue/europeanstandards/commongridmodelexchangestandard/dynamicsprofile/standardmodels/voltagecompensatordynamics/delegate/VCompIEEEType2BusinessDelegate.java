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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * VCompIEEEType2 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VCompIEEEType2 related services in the case of a VCompIEEEType2
 *       business related service failing.
 *   <li>Exposes a simpler, uniform VCompIEEEType2 interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VCompIEEEType2 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VCompIEEEType2BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VCompIEEEType2BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VCompIEEEType2 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VCompIEEEType2BusinessDelegate
   */
  public static VCompIEEEType2BusinessDelegate getVCompIEEEType2Instance() {
    return (new VCompIEEEType2BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVCompIEEEType2(CreateVCompIEEEType2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVCompIEEEType2Id() == null) command.setVCompIEEEType2Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVCompIEEEType2Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVCompIEEEType2Command of VCompIEEEType2 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VCompIEEEType2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVCompIEEEType2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVCompIEEEType2(UpdateVCompIEEEType2Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVCompIEEEType2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VCompIEEEType2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVCompIEEEType2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVCompIEEEType2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVCompIEEEType2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VCompIEEEType2 using Id = " + command.getVCompIEEEType2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VCompIEEEType2 via VCompIEEEType2FetchOneSummary
   *
   * @param summary VCompIEEEType2FetchOneSummary
   * @return VCompIEEEType2FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VCompIEEEType2 getVCompIEEEType2(VCompIEEEType2FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VCompIEEEType2FetchOneSummary arg cannot be null");

    VCompIEEEType2 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VCompIEEEType2
      // --------------------------------------
      CompletableFuture<VCompIEEEType2> futureEntity =
          queryGateway.query(
              new FindVCompIEEEType2Query(
                  new LoadVCompIEEEType2Filter(summary.getVCompIEEEType2Id())),
              ResponseTypes.instanceOf(VCompIEEEType2.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate VCompIEEEType2 with id " + summary.getVCompIEEEType2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VCompIEEEType2s
   *
   * @return List<VCompIEEEType2>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VCompIEEEType2> getAllVCompIEEEType2() throws ProcessingException {
    List<VCompIEEEType2> list = null;

    try {
      CompletableFuture<List<VCompIEEEType2>> futureList =
          queryGateway.query(
              new FindAllVCompIEEEType2Query(),
              ResponseTypes.multipleInstancesOf(VCompIEEEType2.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VCompIEEEType2";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Tr on VCompIEEEType2
   *
   * @param command AssignTrToVCompIEEEType2Command
   * @exception ProcessingException
   */
  public void assignTr(AssignTrToVCompIEEEType2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVCompIEEEType2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    VCompIEEEType2BusinessDelegate parentDelegate =
        VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tr on VCompIEEEType2
   *
   * @param command UnAssignTrFromVCompIEEEType2Command
   * @exception ProcessingException
   */
  public void unAssignTr(UnAssignTrFromVCompIEEEType2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VCompIEEEType2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tr on VCompIEEEType2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VCompIEEEType2
   */
  private VCompIEEEType2 load(UUID id) throws ProcessingException {
    vCompIEEEType2 =
        VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance()
            .getVCompIEEEType2(new VCompIEEEType2FetchOneSummary(id));
    return vCompIEEEType2;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VCompIEEEType2 vCompIEEEType2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(VCompIEEEType2BusinessDelegate.class.getName());
}
