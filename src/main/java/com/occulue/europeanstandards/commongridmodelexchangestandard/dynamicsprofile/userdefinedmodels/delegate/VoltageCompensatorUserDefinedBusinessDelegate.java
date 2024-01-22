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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * VoltageCompensatorUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VoltageCompensatorUserDefined related services in the case of a
 *       VoltageCompensatorUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform VoltageCompensatorUserDefined interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       VoltageCompensatorUserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VoltageCompensatorUserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VoltageCompensatorUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VoltageCompensatorUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VoltageCompensatorUserDefinedBusinessDelegate
   */
  public static VoltageCompensatorUserDefinedBusinessDelegate
      getVoltageCompensatorUserDefinedInstance() {
    return (new VoltageCompensatorUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVoltageCompensatorUserDefined(
      CreateVoltageCompensatorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVoltageCompensatorUserDefinedId() == null)
        command.setVoltageCompensatorUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVoltageCompensatorUserDefinedCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVoltageCompensatorUserDefinedCommand of VoltageCompensatorUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VoltageCompensatorUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVoltageCompensatorUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVoltageCompensatorUserDefined(
      UpdateVoltageCompensatorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVoltageCompensatorUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VoltageCompensatorUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVoltageCompensatorUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVoltageCompensatorUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVoltageCompensatorUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VoltageCompensatorUserDefined using Id = "
              + command.getVoltageCompensatorUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VoltageCompensatorUserDefined via
   * VoltageCompensatorUserDefinedFetchOneSummary
   *
   * @param summary VoltageCompensatorUserDefinedFetchOneSummary
   * @return VoltageCompensatorUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VoltageCompensatorUserDefined getVoltageCompensatorUserDefined(
      VoltageCompensatorUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "VoltageCompensatorUserDefinedFetchOneSummary arg cannot be null");

    VoltageCompensatorUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VoltageCompensatorUserDefined
      // --------------------------------------
      CompletableFuture<VoltageCompensatorUserDefined> futureEntity =
          queryGateway.query(
              new FindVoltageCompensatorUserDefinedQuery(
                  new LoadVoltageCompensatorUserDefinedFilter(
                      summary.getVoltageCompensatorUserDefinedId())),
              ResponseTypes.instanceOf(VoltageCompensatorUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate VoltageCompensatorUserDefined with id "
              + summary.getVoltageCompensatorUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VoltageCompensatorUserDefineds
   *
   * @return List<VoltageCompensatorUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VoltageCompensatorUserDefined> getAllVoltageCompensatorUserDefined()
      throws ProcessingException {
    List<VoltageCompensatorUserDefined> list = null;

    try {
      CompletableFuture<List<VoltageCompensatorUserDefined>> futureList =
          queryGateway.query(
              new FindAllVoltageCompensatorUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(VoltageCompensatorUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VoltageCompensatorUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on VoltageCompensatorUserDefined
   *
   * @param command AssignProprietaryToVoltageCompensatorUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToVoltageCompensatorUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVoltageCompensatorUserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    VoltageCompensatorUserDefinedBusinessDelegate parentDelegate =
        VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Proprietary on VoltageCompensatorUserDefined
   *
   * @param command UnAssignProprietaryFromVoltageCompensatorUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromVoltageCompensatorUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageCompensatorUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on VoltageCompensatorUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VoltageCompensatorUserDefined
   */
  private VoltageCompensatorUserDefined load(UUID id) throws ProcessingException {
    voltageCompensatorUserDefined =
        VoltageCompensatorUserDefinedBusinessDelegate.getVoltageCompensatorUserDefinedInstance()
            .getVoltageCompensatorUserDefined(new VoltageCompensatorUserDefinedFetchOneSummary(id));
    return voltageCompensatorUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VoltageCompensatorUserDefined voltageCompensatorUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageCompensatorUserDefinedBusinessDelegate.class.getName());
}
